//package com.bytes.errs.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.bytes.errs.service.UserService;
//
//@Configuration
//@EnableWebSecurity
//
//public class WebSecurity {
//	@Autowired
//	private UserService userService;
//	private final JwtAuthenticationFilter jwtAuthenticationFilter;
//
//	public WebSecurity(UserService userService,
//			JwtAuthenticationFilter jwtAuthenticationFilter) {
//		this.userService = userService;
//		this.jwtAuthenticationFilter = jwtAuthenticationFilter;
//	}
//
//	@Bean
//	public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder)
//			throws Exception {
//		AuthenticationManagerBuilder authenticationManagerBuilder = http
//				.getSharedObject(AuthenticationManagerBuilder.class);
//		authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
//		return authenticationManagerBuilder.build();
//	}
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
////		http.csrf(csrf -> csrf.disable())
////				.authorizeHttpRequests(requests -> 
////										requests
////										.requestMatchers("/employee/register", "/employee/login")
////										.permitAll()
////										.anyRequest()
////										.authenticated()
////									).sessionManagement(management -> 
////										management
////										.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////									);
//
//		http.csrf(csrf -> csrf.disable())
//				.authorizeHttpRequests(requests -> requests.requestMatchers("/employee/register", "/employee/login")
//						.permitAll().anyRequest().authenticated())
//				.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
//		return http.build();
//	}
//
//	@Bean
//	BCryptPasswordEncoder bCryptPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Bean
//	WebSecurityCustomizer webSecurityCustomizer() {
//		return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
//	}
//	
//	 
//
//}
