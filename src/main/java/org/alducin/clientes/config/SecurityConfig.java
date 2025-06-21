package org.alducin.clientes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
          // Desactiva CSRF (solo en desarrollo)
          .csrf(csrf -> csrf.disable())
          // Permite iframe (para H2)
          .headers(headers -> headers.frameOptions(frame -> frame.disable()))
          // Abre todas las rutas
          .authorizeHttpRequests(auth -> auth
              .anyRequest().permitAll()
          )
          // No queremos login ni httpBasic en dev
          .formLogin(form -> form.disable())
          .httpBasic(basic -> basic.disable());

        return http.build();
    }
}
