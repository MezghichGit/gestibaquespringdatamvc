package com.sip.gestibanque.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sip.gestibanque.entities.User;
import com.sip.gestibanque.repositories.UserRepository;



@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/save")
	public String getFormAdd(Model model)
	{
		User user = new User();
		model.addAttribute("user", user);
		return "user/addUser";
	}
	
	@PostMapping("/save")
	public String save(User user)
	{
		userRepository.save(user); 
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public String getAll(Model model)
	{
		List<User> users = (List<User>) userRepository.findAll();  
		model.addAttribute("users", users);
		return "user/listUser";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id)
	{
		userRepository.deleteById(id); 
		return "redirect:../list";
	}
	
	
	@GetMapping("/update/{id}")
	public String getFormUpdate(@PathVariable("id") int id, Model model)
	{
		Optional<User> opUser = userRepository.findById(id);
		User user = opUser.get(); 
		
		model.addAttribute("user", user);
		
		return "user/updateUser";
	}
	
	
	@PostMapping("/update")
	public String update(User user)
	{
		userRepository.save(user); 
		return "redirect:list";
	}
	
	@GetMapping("/findByName")
	public String findByName(@RequestParam("nom") String nom, Model model) {
		
		List<User> users = userRepository.findByNom(nom);
		model.addAttribute("users", users);
		return "user/listUser";
	}
}
