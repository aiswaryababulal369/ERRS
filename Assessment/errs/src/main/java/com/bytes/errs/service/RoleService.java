package com.bytes.errs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytes.errs.dao.RoleRepository;
import com.bytes.errs.model.Role;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public Role createNewRole(Role role) {
		return roleRepository.save(role);
		 
	 }
}
