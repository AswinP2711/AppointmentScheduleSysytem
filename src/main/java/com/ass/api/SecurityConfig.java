package com.ass.api;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ass.api.service.MyUserDetailsService;
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getDBAuth());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/user/login").authenticated()
		.antMatchers("/user/details").authenticated()
		.antMatchers("/customer/all").authenticated()
		.antMatchers("/customer/delete").authenticated()
		.antMatchers("/doctor/all").authenticated()
		.antMatchers("/doctor/delete").authenticated()
		.antMatchers("/lawyer/all").authenticated()
		.antMatchers("/lawyer/delete").authenticated()
		.anyRequest().permitAll()
		.and()
		.httpBasic()
		.and()
		.csrf().disable();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public DaoAuthenticationProvider getDBAuth() {
		DaoAuthenticationProvider dao=new DaoAuthenticationProvider();
		dao.setPasswordEncoder(getPasswordEncoder());
		dao.setUserDetailsService(myUserDetailsService);
		return dao;
	}

}
