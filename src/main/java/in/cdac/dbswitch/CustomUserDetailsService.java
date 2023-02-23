package in.cdac.dbswitch;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface CustomUserDetailsService {
    UserDetails loadUserByUsernameAndTenantname(String username, String tenantName) throws UsernameNotFoundException;


}
