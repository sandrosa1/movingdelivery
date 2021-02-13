package com.movingdelivery.movingdelivery.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment env;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//LIBERA ACESSO AO BANCO DE DADOS H2 EM MEMORIA
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
			http.headers().frameOptions().disable();
		}
		
		
		//DESABILITA O CSRF, UMA VEZ QUE A APLICAÇÃO É REST
		http.cors().and().csrf().disable();
		//NAO ARMAZENA ESTADO
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		//LIBERA ACESSO A TODOS OS REQUESTS
		http.authorizeRequests().anyRequest().permitAll();
	}
	
	//DESBLOQUEIA APLICAÇÔES NAVEGAREM ENTE DOMINIOS ATAVES DO CORS
	//PERMITE A COMUNICAÇÂO DO BACKEND COM FRONTEND HOSPEDADO EM LOCAIS DIFERENTES
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
