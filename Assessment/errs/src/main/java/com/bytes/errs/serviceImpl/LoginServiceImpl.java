package com.bytes.errs.serviceImpl;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.bytes.errs.configuration.Utility;
import com.bytes.errs.dao.UserRepository;
import com.bytes.errs.exception.InvalidCredentialsException;
import com.bytes.errs.model.User;
import com.bytes.errs.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	public UserRepository userRepository;
	

	@Override
//	 public User findByUsername(User user) {
//		User currentUser = userRepository.findByUserName(user.getUserName());
//		
//		if(currentUser==null) {
//			throw new InvalidCredentialsException("Invalid username or password");
//		}
//		
//		boolean passwordSame = BCrypt.checkpw(user.getUserPassword(), currentUser.getUserPassword());
//		if (currentUser != null && passwordSame ) {
//            return currentUser;
//        } else {
//        	throw new InvalidCredentialsException("Invalid username or password");
//        }
//	}
	
	public User findByUsername(User user) {
	    User currentUser = userRepository.findByUserName(user.getUserName());
	    
	    if (currentUser != null && BCrypt.checkpw(user.getUserPassword(), currentUser.getUserPassword())) {
	        return currentUser;
	    } else {
	        throw new InvalidCredentialsException("Invalid username or password");
	    }
	}


	@Override
	public User verifyUser(String emailId, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	public User verifyUser(String emailId, String password) {
//		User registerUser = userRepository.findByUserName(emailId);
//		Boolean passWordMatch = Utility.verifyHashedStringMatch(password, registerUser.getUserPassword());
//
//		if (registerUser != null && passWordMatch) {
//			return registerUser;
//		}
//
//		return null;
//	}

}
