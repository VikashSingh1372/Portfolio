package com.portfolio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class config {

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().requestMatchers("/admin/**").hasAuthority("ADMIN")
         .requestMatchers("/**").permitAll().and().formLogin().loginPage("/login").usernameParameter("email").passwordParameter("password")
        .defaultSuccessUrl("/admin/home")
        .and().logout() .and().csrf().disable();
		http.authenticationProvider(daoauthenticationProvider());
		DefaultSecurityFilterChain build = http.build();
		// login work has been finished
		
		return build;

	}
	


	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
		
	}
	

	

	@Bean
	public UserDetailsService userdetailservice() {
		return new userDetailsService();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

	@Bean
	public DaoAuthenticationProvider daoauthenticationProvider() {
		DaoAuthenticationProvider daoauthenticationProvider = new DaoAuthenticationProvider();
		daoauthenticationProvider.setUserDetailsService(this.userdetailservice());
		daoauthenticationProvider.setPasswordEncoder(passwordEncoder());

		return daoauthenticationProvider;

	}

}
