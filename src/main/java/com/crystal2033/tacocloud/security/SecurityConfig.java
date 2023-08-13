package com.crystal2033.tacocloud.security;

import com.crystal2033.tacocloud.models.User;
import com.crystal2033.tacocloud.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @project TacoCloud
 * ©Crystal2033
 * @date 01/08/2023
 */

@Configuration
@EnableMethodSecurity //for @PreAuthorize("hasRole('ADMIN')")
public class SecurityConfig{
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
            User user = userRepository.findByUsername(username);
            if (user != null) return user;
            throw new UsernameNotFoundException("User ‘" + username + "’ not found");
            //return Optional.of(user).orElseThrow(()->new UsernameNotFoundException("User " + username + " not found"));
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeHttpRequest -> {
                    authorizeHttpRequest
                            .requestMatchers("/design", "/orders").hasRole("USER")
//                            .requestMatchers("/", "/**").permitAll()
                            .requestMatchers(HttpMethod.POST, "/api/ingredients")
                            .hasAuthority("SCOPE_writeIngredients")
                            .requestMatchers(HttpMethod.DELETE, "/api/ingredients")
                            .hasAuthority("SCOPE_deleteIngredients")
                            .anyRequest().authenticated();
                })
                .oauth2ResourceServer(oauth2-> oauth2.jwt(Customizer.withDefaults()))
//                .csrf(csrf -> {
//                    csrf.disable();
//                })
//                .headers(headers -> {
//                    headers.frameOptions(options -> {
//                        options.disable();
//                    });
//                })
                .formLogin(form -> {
                    form.loginPage("/login").defaultSuccessUrl("/design");
                })
                .oauth2Login(login -> {
                    login.loginPage("/login");
                })
                .logout(logout -> {
                    logout.logoutSuccessUrl("/");
                });
        return http.build();
    }

}
