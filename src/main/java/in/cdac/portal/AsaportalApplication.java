package in.cdac.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@SpringBootApplication

public class AsaportalApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsaportalApplication.class, args);
	}
	 @Bean
	    public HttpFirewall allowUrlSemicolonHttpFirewall() {
	        StrictHttpFirewall firewall = new StrictHttpFirewall();
	        firewall.setAllowSemicolon(true);
	        return firewall;
	    }

}
