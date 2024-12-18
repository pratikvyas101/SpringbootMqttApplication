package com.pratik.mqttapp.mqttapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



//import com.pratik.mqttapp.mqttapp.service.JwtAuthenticationEntryPoint;
//import com.pratik.mqttapp.mqttapp.service.JwtAuthenticationFilter;

import jakarta.servlet.Filter;

@Configuration
public class SecurityConfig {
	
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource); 
		
//		jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,pw,active from members where user_id=?");
//		
//		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id=?");
//		
		return jdbcUserDetailsManager;
	}
  

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(configurer -> configurer.requestMatchers("/vehicleState/**").hasRole("DRIVER").requestMatchers("/vehicleState/**")
								.hasRole("OWNER").requestMatchers("/vehicleState/**").hasRole("ADMIN").anyRequest().authenticated()).
								formLogin(form -> form.loginPage("/showMyLoginPage").loginProcessingUrl("/vehicleState").defaultSuccessUrl("/vehicleState", true)
								.permitAll()).logout(logout->logout
							            .logoutUrl("/logout").logoutSuccessUrl("/showMyLoginPage?logout=true").permitAll())
								.exceptionHandling(configurer->configurer.accessDeniedPage("/access-denied"));
		
		return http.build();
		
	}  
	  
	
	

	
//	@Bean
//	public InMemoryUserDetailsManager userDetailsManager() {
//		
//		UserDetails john = User.builder().username("john").password("{noop}test123").roles("DRIVER").build();
//		
//		UserDetails marry = User.builder().username("marry").password("{noop}test123").roles("DRIVER","OWNER").build();
//		
//		UserDetails susan = User.builder().username("susan").password("{noop}test123").roles("DRIVER","OWNER","ADMIN").build();
//		
//		return new InMemoryUserDetailsManager(john,marry,susan);
//		
//	}
	
	
}
