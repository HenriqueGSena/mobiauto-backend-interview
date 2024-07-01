package com.mobiauto.backend_interview.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    SecurityFilter securityFilter;

    private static final String[] SWAGGER_WHITELIST = {
            "/api-docs",
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/swagger-resources/**",
            "/webjars/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .cors(cors -> cors.disable())
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(SWAGGER_WHITELIST).permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/revendas/criar").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/revendas/listar").hasAnyRole("ADMIN", "PROPRIETARIO")
                        .requestMatchers(HttpMethod.POST, "/usuarios/{usuarioId}/revendas/{revendaId}").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/usuarios/listar").hasAnyRole("ADMIN", "PROPRIETARIO")
                        .requestMatchers(HttpMethod.PUT, "/usuarios/atualizar/{usuarioId}").hasAnyRole("ADMIN", "PROPRIETARIO")
                        .requestMatchers(HttpMethod.POST, "/oportunidade/criar").hasAnyRole("ADMIN", "PROPRIETARIO", "GERENTE", "ASSISTENTE")
                        .requestMatchers(HttpMethod.GET, "/oportunidade/listar").hasAnyRole("ADMIN", "PROPRIETARIO", "GERENTE", "ASSISTENTE")
                        .requestMatchers(HttpMethod.POST, "oportunidade/{oportunidadeId}/oportunidade/{usuarioId}").hasAnyRole("ADMIN", "PROPRIETARIO", "GERENTE")
                        .requestMatchers(HttpMethod.PUT, "/oportunidade/atualizar/{oportunidadeId}").hasAnyRole("ADMIN", "PROPRIETARIO", "GERENTE", "ASSISTENTE")
                        .requestMatchers(HttpMethod.POST, "/cliente/criar").hasAnyRole("ADMIN", "PROPRIETARIO", "GERENTE", "ASSISTENTE")
                        .requestMatchers(HttpMethod.PUT, "/cliente/atualizar/{clienteId}").hasAnyRole("ADMIN", "PROPRIETARIO", "GERENTE", "ASSISTENTE")
                        .requestMatchers(HttpMethod.GET, "/cliente/listar").hasAnyRole("ADMIN", "PROPRIETARIO", "GERENTE", "ASSISTENTE")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
