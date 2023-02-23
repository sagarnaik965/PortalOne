package in.cdac.portal.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//import nl.captcha.Captcha;
import cn.apiclub.captcha.Captcha;
import in.cdac.dbswitch.CustomeUserDetails;
import in.cdac.portal.modal.Constant;
import in.cdac.portal.modal.PortalConstant;
import in.cdac.portal.service.UserService;
import in.cdac.portal.util.Util;

@Controller
@RequestMapping("/")
@SessionAttributes({ "captchaValue" })
public class HomeController {

	private final static Logger logger = Logger.getLogger(HomeController.class);

	@Autowired
	UserService userService;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	Util util;

	static HttpSession sess;

	@Autowired
	@Qualifier("test_ds")
	DataSource ds1;

	@Autowired
	@Qualifier("preproduction_ds")
	DataSource ds2;

	@Autowired
	@Qualifier("production_ds")
	DataSource ds3;

	@Autowired
	Environment env;

	@Autowired
	ServletContext context;

	private DataSource getdaDataSource(String tenantName) {
		logger.info("tenant name in getdaDataSource::" + tenantName);
		if (tenantName.equalsIgnoreCase("test")) {

		//	logger.info("return DS " + ds1.toString());
			return ds1;
		} else if (tenantName.equalsIgnoreCase("preproduction")) {

			//logger.info("return DS " + ds2.toString());
			return ds2;
		} else if (tenantName.equals("production")) {

			//logger.info("return DS " + ds3.toString());
			return ds3;
		}
	//	logger.info("return DS NULL");
		return null;
	}

	private String getTenantName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String tenantName = null;
		if (auth != null && !auth.getClass().equals(AnonymousAuthenticationToken.class)) {
			CustomeUserDetails userDetails = (CustomeUserDetails) auth.getPrincipal();
			tenantName = userDetails.getTenant();
		}
		return tenantName;
	}

	String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	@CrossOrigin(origins = PortalConstant.BASEURL + PortalConstant.PORT)
	// @RequestMapping
	@GetMapping(path = "/userLogout")
	public RedirectView loggingOut() {
		String user = "";
		try {
			if (sess != null) {
				user = (String) sess.getAttribute("email");
			}
			String email = "";
			if (getPrincipal().isEmpty()) {
				email = userService.getCurrentEmailId(getPrincipal());
			}

			DeptController.sess = null;
			sess = null;
			String temp = "";
			SecurityContextHolder.clearContext();
			RedirectView redirectView = new RedirectView();

			redirectView.setUrl(PortalConstant.LOGOUT);
			return redirectView;

		} catch (Exception e) {
			DeptController.sess = null;
			sess = null;
			SecurityContextHolder.clearContext();
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(PortalConstant.LOGOUT);
			return redirectView;
		}
	}

	@CrossOrigin(origins = PortalConstant.BASEURL + PortalConstant.PORT)
	@RequestMapping(path = "/isSessNull")
	@GetMapping
	@JsonManagedReference
	public RedirectView isSessNull() {

		try {
			String user = "";
			if (sess != null) {
				return null;
			} else {
				RedirectView redirectView = new RedirectView();

				redirectView.setUrl(PortalConstant.LOGOUT);
				return redirectView;
			}

		} catch (Exception e) {
			// TODO: handle exception
			sess = null;
			SecurityContextHolder.clearContext();
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(PortalConstant.LOGOUT);
			return redirectView;
		}

	}

	@RequestMapping(value = { "/", "home" }, method = RequestMethod.GET)
	public RedirectView getHome(HttpSession session) {

		sess = session;
		DeptController.sess = sess;

		logger.info("/home::" + SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		String email = userService.getCurrentEmailId(getPrincipal());
		String username = getPrincipal();
		session.setAttribute("email", email);
		session.setAttribute("username", username);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(PortalConstant.BASEURL + PortalConstant.PORT + PortalConstant.REACTHOME);
		return redirectView;

	}

	@RequestMapping(value = "/login")
	public ModelAndView getLogin(@RequestParam(required = false) String authfailed, String logout, String denied,
			String captchainvalid, String disabled) {
		RedirectView redirectView = new RedirectView();

		String message = "";
		if (captchainvalid != null) {
			message = "Invalid Captcha!";
		} else if (authfailed != null) {
			message = "Invalid credentials, try again!";
		} else if (disabled != null) {
			message = "User is disabled!";
		} else if (logout != null) {
			message = "Logged Out successfully, login again to continue!";
			return new ModelAndView("login", "successMessage", message);
		} else if (denied != null) {
			message = "Access denied for this user!";
		} else if (!getPrincipal().equals("anonymousUser")) {

			return new ModelAndView("home");
		}

		return new ModelAndView("login", "errorMessage", message);
	}

	@RequestMapping(value = "captcha.png", method = RequestMethod.GET)
	public void captcha(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		logger.info("Inside Captcha Generation Class------------");
		Captcha captcha = new Captcha.Builder(152, 47).addText().addBackground().addNoise().gimp().build();
		logger.info("----------Captcha value generated : " + captcha.getAnswer());
		model.addAttribute(Constant.CAPTCHA_NAME, captcha.getAnswer());
		BufferedImage image = captcha.getImage();
		logger.info("Captcha Generated ------------");
		ServletOutputStream servletOutputStream = response.getOutputStream();
		ImageIO.write(image, "PNG", servletOutputStream);
		logger.info("Successfully captcha pushed to stream------------");
	}

}
