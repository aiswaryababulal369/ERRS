//package com.bytes.errs.configuration;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Utility {
//
//	public static String getHashedString(String strToHash) {
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String hashedPassword = passwordEncoder.encode(strToHash);
//		return hashedPassword;
//	}
//	
//	public static Boolean verifyHashedStringMatch(String strToHash, String hashedString) {
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String hashedPassword = passwordEncoder.encode(strToHash);
//		boolean matches = passwordEncoder.matches(strToHash, hashedPassword);
//		return matches;
//	}
//}
