package com.ssoysal.letMeIn.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.inMemoryAuthentication()
        .passwordEncoder(new BCryptPasswordEncoder())
            .withUser("nani")
            .password("$2a$10$SzIY3CCIwDa10iklU.bx8e3e.Vu18GoEh8yjTLcyZ2SDbxbx3FeUO")
            .roles("USER")
        .and()
            .withUser("greatnani")
            .password("$2a$10$vHnI4IsfPA6UASQWYPBnAOu.rg6ZAm.HEfdJip19HG.HYuDqyR8pW")
            .roles("ADMIN")
        ;
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().and().formLogin().disable() 
				.authorizeRequests()
		        .antMatchers("/api/logins").hasAnyRole("USER", "ADMIN")
		        .antMatchers("/add/*", "/update/*", "/delete/*").hasRole("ADMIN")
		        .anyRequest().authenticated()
        		.and()
        		.httpBasic();
	}
}