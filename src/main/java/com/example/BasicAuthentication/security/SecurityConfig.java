package com.example.BasicAuthentication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth)  throws Exception 
	{
		  auth.inMemoryAuthentication().withUser("alberto").password("alberto").roles("ADMIN");
		  auth.inMemoryAuthentication().withUser("user").password("user").roles("user");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("/*/todos_profesores").permitAll()
		.antMatchers("/*/todos_profesores_admin").hasRole("ADMIN")
		.antMatchers("/*/todos_profesores_user").hasRole("USER")
		.antMatchers("/*/escribirDB/**").hasRole("ADMIN")
		.and()
		.httpBasic();
	}
	
	/**
	@Bean
	public static NoOpPasswordEncoder passwordEncoder()
	{
		returm NoOpPasswordEn
	}
***/
}
