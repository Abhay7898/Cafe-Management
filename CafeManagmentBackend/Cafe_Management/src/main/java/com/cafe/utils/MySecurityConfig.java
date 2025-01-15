package com.cafe.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@EnableWebSecurity
@Configuration
//@EnableMethodSecurity
public class MySecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/*
	 * @Bean public AuthenticationManager
	 * authenticationManager(AuthenticationConfiguration
	 * authenticationConfiguration) throws Exception { return
	 * authenticationConfiguration.getAuthenticationManager(); }
	 */

	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("*");
            }
        };
    }

	/*
	 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
	 * Exception { http.csrf().disable().cors().disable().authorizeHttpRequests().
	 * requestMatchers("*").permitAll()
	 * .requestMatchers(HttpMethod.OPTIONS).permitAll().anyRequest().authenticated()
	 * .and().sessionManagement()
	 * .sessionCreationPolicy(SessionCreationPolicy.STATELESS); return http.build();
	 * }
	 */
}
