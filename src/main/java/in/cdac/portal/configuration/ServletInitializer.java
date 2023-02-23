package in.cdac.portal.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	    protected Class<?>[] getServletConfigClasses() {
	        return new Class[] { SpringConfig.class, SpringSecurity.class };
	    }

	    @Override
	    protected String[] getServletMappings() {
	        return new String[] { "/" };
	    }

	    @Override
	    protected Class<?>[] getRootConfigClasses() {
	        return null;
	    }

}
