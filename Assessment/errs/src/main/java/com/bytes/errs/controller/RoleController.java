package com.bytes.errs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytes.errs.model.Role;
import com.bytes.errs.service.RoleService;

@RestController
@RequestMapping(value = "role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/createNewRole")
	public Role createNewRole(@RequestBody Role role) {
		return roleService.createNewRole(role);
		
	}

}
