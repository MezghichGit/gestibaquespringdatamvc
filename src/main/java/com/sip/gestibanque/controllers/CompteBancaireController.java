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
import com.sip.gestibanque.entities.User;
import com.sip.gestibanque.repositories.BanqueRepository;
import com.sip.gestibanque.repositories.CompteBancaireRepository;

@Controller
@RequestMapping("/compte")
public class CompteBancaireController {

	
	private final CompteBancaireRepository cbRepo;

	private final BanqueRepository banqueRepository;
	
	@Autowired
	public CompteBancaireController(CompteBancaireRepository cbRepo, BanqueRepository banqueRepository)
	{
		this.banqueRepository = banqueRepository;
		this.cbRepo = cbRepo;
	}
	
	@RequestMapping("/list")
	//@ResponseBody
	public String listCompteBancaire(Model model) {
		
		List<CompteBancaire> comptes = (List<CompteBancaire>) cbRepo.findAll();
		model.addAttribute("comptes", comptes);
		return "compte/listCompteBancaire";
		//return comptes.toString();
	}
	
	@GetMapping("/add")
	public String addCompteBancaire(Model model) {
		
		CompteBancaire cb = new CompteBancaire();
		model.addAttribute("cb", cb);
		List<Banque> banques = (List<Banque>) this.banqueRepository.findAll();
		model.addAttribute("banques", banques);
		return "compte/addCompteBancaire";
	}
	
	@PostMapping("/add")
	//@ResponseBody
	public String saveCompteBancaire(CompteBancaire cb) {
		
		cbRepo.save(cb);
		return "redirect:list";
		//return cb.toString();
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCompteBancaire(@PathVariable("id") int id) {
		cbRepo.deleteById(id);
		return "redirect:../list";
	}
	
	@GetMapping("/update/{id}")
	public String updateCompteBancaire(@PathVariable("id") int id, Model model) {
		
		Optional <CompteBancaire> op_cb = cbRepo.findById(id);
		CompteBancaire cb = op_cb.get();
		model.addAttribute("cb", cb);
		
		return "compte/updateCompteBancaire";
	}
	
	@PostMapping("/update")
	public String updateCompteBancaire(CompteBancaire cb) {
		
		cbRepo.save(cb);
		return "compte/updateCompteBancaire";
	}
	
	@GetMapping("/findByProprietaire")
	public String findByName(@RequestParam("proprietaire") String proprietaire, Model model) {
		
		List<CompteBancaire> cbs = cbRepo.findByProprietaire(proprietaire);
		model.addAttribute("comptes", cbs);
		return "compte/listCompteBancaire";
	}
	
	
}
