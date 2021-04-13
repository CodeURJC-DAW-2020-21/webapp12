package undersociety.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@Order(1)
public class RestSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Private endpoints
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/**").hasRole("USER");
		// Disable CSRF protection (it is difficult to implement in REST APIs)
		http.csrf().ignoringAntMatchers("/api/**");
		http.formLogin().disable().antMatcher("/api/**");
		// Enable Basic Authentication
		http.httpBasic();
		// Avoid creating session (because every request has credentials) 
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
