package com.deckburger.cardapio.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfigurations extends WebSecurityConfigurerAdapter{
		
	
	//Configuracoes de autenticacao
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
        .withUser("deck").password("{noop}tocomfome").roles("DECK");
	}
	
	//Configuracoes de autenticacao
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/css/**", "/images/**").permitAll()
		.antMatchers(HttpMethod.GET, "/dashboard").hasRole("DECK")
		.antMatchers(HttpMethod.POST, "/dashboard").hasRole("DECK")
		.antMatchers(HttpMethod.GET, "/criaritem").hasRole("DECK")
		.antMatchers(HttpMethod.POST, "/criaritem").hasRole("DECK")
		.antMatchers(HttpMethod.POST, "/salvaritem").hasRole("DECK")
		.antMatchers(HttpMethod.POST, "/deletaritem/**").hasRole("DECK")
		.anyRequest().permitAll()
		.and().formLogin();
		
	}
	
	//Configuracoes de recursos estaticos (js, css, imagens etc)
	@Override
	public void configure(WebSecurity web) throws Exception {
		
	}
	
}
