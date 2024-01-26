package com.sip.gestibanque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.gestibanque.entities.Role;
import com.sip.gestibanque.repositories.RoleRepository;

@Controller
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	RoleRepository roleRepository;
	
	@RequestMapping("/save")
	@ResponseBody
	public String addRoles()
	{
		
		//Role role = roleRepository.save(new Role("SUPERADMIN"));
		//Role role = roleRepository.save(new Role("ADMIN"));
		Role role = roleRepository.save(new Role("CLIENT"));
		return role.toString();
	}

}
