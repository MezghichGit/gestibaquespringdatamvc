package com.sip.gestibanque.services;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.gestibanque.entities.Role;
import com.sip.gestibanque.entities.User;
import com.sip.gestibanque.repositories.RoleRepository;
import com.sip.gestibanque.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	
	public User saveUser(User user)
	{
		//Role userRole1 = roleRepository.findByLibelle("ADMIN");
		//Role userRole2 = roleRepository.findByLibelle("SUPERADMIN");
		Role userRole = roleRepository.findByLibelle("CLIENT");
		//User temp = userRepository.findById(102).get();
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
	
		return userRepository.save(user);
	}

}
