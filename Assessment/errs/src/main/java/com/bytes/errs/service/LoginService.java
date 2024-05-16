package com.bytes.errs.service;

import org.springframework.stereotype.Service;

import com.bytes.errs.model.User;


@Service
public interface LoginService {

	User findByUsername(User user);
	User verifyUser(String emailId, String password);

}
