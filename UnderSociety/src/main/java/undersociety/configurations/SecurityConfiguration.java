package undersociety.configurations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import undersociety.services.RepositoryUserDetailsService;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public RepositoryUserDetailsService userDetailServices;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailServices).passwordEncoder(passwordEncoder());
	 }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.authorizeRequests().antMatchers( "/css/**").permitAll();
		 http.authorizeRequests().antMatchers( "/js/**").permitAll();
		 http.authorizeRequests().antMatchers( "/lib/**").permitAll();
		 http.authorizeRequests().antMatchers( "/js/**").permitAll();
		 http.authorizeRequests().antMatchers( "/images/**").permitAll();
		 http.authorizeRequests().antMatchers( "/fonts/**").permitAll();
		 http.authorizeRequests().antMatchers( "/ajax/**").permitAll();
		 http.authorizeRequests().antMatchers("/sign-in").permitAll();
		 http.authorizeRequests().antMatchers("/registerUser").permitAll();
		 http.authorizeRequests().antMatchers("/registerCompany").permitAll();
		 http.authorizeRequests().antMatchers("/forgotPassword").permitAll();
		 http.authorizeRequests().antMatchers("/login").permitAll();
		 http.authorizeRequests().antMatchers("/forgotpasswordmail").permitAll();
		 http.authorizeRequests().antMatchers("/error").permitAll();
		 http.authorizeRequests().antMatchers("httpss://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.js").permitAll();
		 http.authorizeRequests().antMatchers("/api/**").permitAll();
		 http.authorizeRequests().antMatchers("/swagger-ui.html").permitAll();
		 http.authorizeRequests().antMatchers("/v3/**").permitAll();
		 http.authorizeRequests().antMatchers("/swagger-ui/**").permitAll();

		 http.csrf().ignoringAntMatchers("/api/**");
		 http.csrf().ignoringAntMatchers("/swagger-ui/**");
		 http.csrf().ignoringAntMatchers("/v3/**");
		 http.csrf().ignoringAntMatchers("/login");
		 http.authorizeRequests().antMatchers("/admin").hasAnyRole("ADMIN");
		 
		 http.authorizeRequests().anyRequest().authenticated();

		 http.formLogin().loginPage("/login");
		 http.formLogin().usernameParameter("username");
		 http.formLogin().passwordParameter("password");
		 http.formLogin().defaultSuccessUrl("/index",true);
		 http.formLogin().failureUrl("/sign-in");
		 
		 http.logout().logoutUrl("/logout");
		 http.logout().logoutSuccessUrl("/sign-in");		
		 
	}

}
