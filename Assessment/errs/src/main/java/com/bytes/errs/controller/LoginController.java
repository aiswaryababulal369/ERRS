package com.bytes.errs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.bytes.errs.configuration.JwtUtil;
import com.bytes.errs.dto.ErrorRes;
import com.bytes.errs.dto.LoginRes;
import com.bytes.errs.model.User;
import com.bytes.errs.service.LoginService;


@RestController
@RequestMapping(value = "user")
@CrossOrigin(origins = "*")
public class LoginController{
	
	

//	@Autowired
//	private UserService userService;
	
	
//	public LoginController(UserService userService) {
//		this.userService=userService;
//	}
//	
//	@Autowired
//	private UserService returnUserService(UserService userService) {
//		return this.userService=userService;
//	}

//	private final AuthenticationManager authenticationManager;
//	private JwtUtil jwtUtil;
	
	
	@Autowired
	public LoginService loginService;
	
	
	@PostMapping("/login")
	public User Login(@RequestBody User user) {
		return loginService.findByUsername(user);		
	}
	
	
//	public LoginController(LoginService loginService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
//		this.loginService = loginService;
//		this.authenticationManager = authenticationManager;
////		this.jwtUtil = jwtUtil;
//	}

//	@SuppressWarnings("rawtypes")
//	@PostMapping("/login")
//	public ResponseEntity login(@RequestBody User registerUser) {
//		try {
//			String emailId = registerUser.getUserName();
//			String password = registerUser.getUserPassword();
//
//			User userToBeLoggedIn = loginService.verifyUser(emailId, password);
//
////			if (userToBeLoggedIn != null) {
////				Authentication authentication = authenticationManager
////						.authenticate(new UsernamePasswordAuthenticationToken(emailId, password));
////				String email = authentication.getName();
////				// RegisterUser user = new RegisterUser(email,"");
////				String token = jwtUtil.createToken(userToBeLoggedIn);
////				userToBeLoggedIn.setUserPassword("xxxxxx");
////				LoginRes loginRes = new LoginRes(email, token);
////
////				return ResponseEntity.ok(loginRes);
////			}
//		} catch (BadCredentialsException e) {
//			ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST,
//					"Invalid username or password");
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//		} catch (Exception e) {
//			ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//		}
//
//		return null;
//	}

}


