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
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.gestibanque.entities.Banque;
import com.sip.gestibanque.entities.CompteBancaire;
import com.sip.gestibanque.repositories.BanqueRepository;

@Controller
@RequestMapping("/banques")
public class BanqueController {
	
	@Autowired  // iOC(inversion of control) = Injection de dépendances
	BanqueRepository banqueRepository;
	
	
	@GetMapping("/save")
	public String getFormAddBanque(Model model)
	{
		//Banque banque = new Banque("abc","paris",12000);
		Banque banque = new Banque();
		model.addAttribute("banque", banque);
		return "banque/addBanque";
	}
	
	
	@PostMapping("/save")
	//@ResponseBody
	public String saveBanque(Banque banque)
	{
		banqueRepository.save(banque);  // save : insert
		//return res.toString();
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	//@ResponseBody
	public String getAllBanques(Model model)
	{
		List<Banque> banques = (List<Banque>) banqueRepository.findAll();  // select *
		model.addAttribute("banques", banques);
		//return banques.toString();
		return "banque/listBanque";
	}
	
	@GetMapping("/delete/{id}")
	//@ResponseBody
	public String deleteBanque(@PathVariable("id") int id)
	{
		banqueRepository.deleteById(id);  // delete
		//List<Banque> banques = (List<Banque>) banqueRepository.findAll(); 
		//return banques.toString();
		return "redirect:../list";
	}
	
	
	@GetMapping("/update/{id}")
	public String getFormUpdateBanque(@PathVariable("id") int id, Model model)
	{
		Optional<Banque> opBanque = banqueRepository.findById(id);
		Banque banque = opBanque.get(); //banque qui est remplis depuis la base
		
		model.addAttribute("banque", banque);
		
		return "banque/updateBanque";
	}
	
	
	@PostMapping("/update")
	//@ResponseBody
	public String updateBanque(Banque banque)
	{
		banqueRepository.save(banque);  // save : insert
		return "redirect:list";
	}
	
	@GetMapping("/findByName")
	public String findByName(@RequestParam("nom") String nom, Model model) {
		
		List<Banque> banques = banqueRepository.findByNom(nom);
		model.addAttribute("banques", banques);
		return "banque/listBanque";
	}
	

}
