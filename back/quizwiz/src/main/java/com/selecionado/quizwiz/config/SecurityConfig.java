package com.selecionado.quizwiz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JWTAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->  auth.requestMatchers("/api/v1/usuarios/registro", "/api/v1/login", "/swagger-ui/**", "/v3/api-docs/**")
                        .permitAll())
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers(
                                        "/api/v1/usuarios/**",
                                "/api/v1/preguntas/**",
                                "/api/v1/respuestas/**",
                                "/api/v1/formularios/**",
                                "/api/v1/opciones/**",
                                "/api/v1/formularios_respondidos/**",
                                "/api/v1/grupos/**").hasAnyRole("USER", "ADMIN"))
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers(
                                "/api/v1/roles/**").hasRole( "ADMIN"))
                .sessionManagement(session->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
