package com.bloodbank.universal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.bloodbank.universal.service.SystemUserDetailsService;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	SystemUserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
	
		 	http.csrf().disable();
	        
	        http.authorizeRequests()        
	        .antMatchers("/").permitAll()
	        .antMatchers("/web/**").permitAll()
	        .antMatchers("/user/**").permitAll()
	        .and()        
	        .formLogin().loginPage("/web/login").permitAll()
	        .defaultSuccessUrl("/user/home").usernameParameter("userEmail")
	        .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/user/logout")).logoutSuccessUrl("/web/home")
	        .and().httpBasic();		
			
		
		/*
		 .antMatchers("/category/**").hasRole("ADMIN")
	        .antMatchers("/user/**").hasRole("ADMIN")
	        .antMatchers("/subcategory/**").hasRole("ADMIN")
	        .antMatchers("/brand/**").hasAnyRole("ADMIN","MANAGER")
	        .antMatchers("/grade/**").hasAnyRole("ADMIN","MANAGER")
	        .antMatchers("/dealer/**").hasRole("ADMIN")
	        .antMatchers("/branchoffice/**").hasRole("ADMIN")
	        .antMatchers("/psize/**").hasAnyRole("ADMIN","MANAGER")
	        .antMatchers("/product/**").hasAnyRole("ADMIN","MANAGER")
	        .antMatchers("/purchase/**").hasAnyRole("ADMIN","MANAGER")
	        .antMatchers("/stock/**").hasAnyRole("ADMIN","MANAGER","RECEPTION")
	        .antMatchers("/sales/**").hasAnyRole("ADMIN","MANAGER","RECEPTION")
	        .antMatchers("/report/**").hasAnyRole("ADMIN","MANAGER","RECEPTION","DISPATCHER")
	        .antMatchers("/dispatch/**").hasAnyRole("ADMIN","MANAGER","DISPATCHER")
	        
		 */
	}
	 @Bean
	    public PasswordEncoder getPasswordEncoder() {
	        return NoOpPasswordEncoder.getInstance();
	    }
}
