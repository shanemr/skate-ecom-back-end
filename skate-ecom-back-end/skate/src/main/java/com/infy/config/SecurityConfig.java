package com.infy.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.infy.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	CustomUserDetailsService userDetailsService;
	
//	@Autowired
//	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtAuthFilter jwtAuthFilter;
	  
	    @SuppressWarnings("removal")
		@Bean
	    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
            http.cors(withDefaults()).csrf(csfr -> csfr.disable()).authorizeHttpRequests(authorizeHttpRequests -> {
                        try {
                            authorizeHttpRequests
                                    .requestMatchers("auth/**").permitAll()
                                    .requestMatchers("/api/**").permitAll()
                                    .anyRequest()
                                    .authenticated()
                                    .and()
                                    .sessionManagement(management -> management
                                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                    .authenticationProvider(authenticationProvider())
                                    .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();

                        }
                    }
            );
	    	return http.build();
		}
	    
	    
	    @Bean
	     AuthenticationProvider authenticationProvider(){
	    	final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	    	authenticationProvider.setUserDetailsService(userDetailsService);
	    	authenticationProvider.setPasswordEncoder(passwordEncoder());
	    	
	    	return authenticationProvider;
	    }
	    
	    
	   
	    @Bean 
		AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
			return config.getAuthenticationManager();
		}
	    
	    @SuppressWarnings("deprecation")
		@Bean
	    PasswordEncoder passwordEncoder() {
			// TODO Auto-generated method stub
			return NoOpPasswordEncoder.getInstance();
		}

	    
}
