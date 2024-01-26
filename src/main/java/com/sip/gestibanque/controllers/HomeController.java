package com.sip.gestibanque.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



import com.sip.gestibanque.repositories.BanqueRepository;
import com.sip.gestibanque.repositories.CompteBancaireRepository;
import com.sip.gestibanque.repositories.MessageRepository;
import com.sip.gestibanque.repositories.UserRepository;

@Controller
public class HomeController {
	
	private UserRepository userRepo;
	private BanqueRepository banqueRepo;
	private CompteBancaireRepository cbRepo;
	private MessageRepository messageRepo;
	
	public HomeController(UserRepository userRepo, BanqueRepository banqueRepo, CompteBancaireRepository cbRepo,
			MessageRepository messageRepo) {
		this.userRepo = userRepo;
		this.banqueRepo = banqueRepo;
		this.cbRepo = cbRepo;
		this.messageRepo = messageRepo;
	}

	@GetMapping({"/", "/home"})
	public String getFormAdd(Model model)
	{
		model.addAttribute("nbBanque", banqueRepo.count());
		model.addAttribute("nbUser", userRepo.count());
		model.addAttribute("nbCompte", cbRepo.count());
		model.addAttribute("nbMessage", messageRepo.count());
		return "home";
	}

}
