package com.sip.gestibanque.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
import com.sip.gestibanque.entities.Message;
import com.sip.gestibanque.repositories.MessageRepository;

@Controller
@RequestMapping("/messages")
public class MessageController {
	
	// On créer une liste générale des messages (donc static)
	static List<Message> messages = new ArrayList<>();
		
	/* La "Best Practice" de Benoit pour le repository	
	private MessageRepository messageRepository;
	
	public MessageController(MessageRepository messageRepository) {
		super();
		this.messageRepository = messageRepository;
	}
*/
	@Autowired // iOC(inversion of control) = Injection de dépendances
	MessageRepository messageRepository;
	
	@GetMapping("/save")
	public String getFormNewMessage(Model model) {
		Message message = new Message();
		model.addAttribute("message", message);
		return "message/formulaireMessage";
	}
	
	@PostMapping("/save")
	public String saveMessage(Message message) {
		message.setDateCreation(LocalDate.now());
		messageRepository.save(message);
		return "redirect:list";
	}

	// Get list
	@RequestMapping("/list") // la dernière partie de l'URL
	public String getAllMessages(Model model) {
		messages = (List<Message>) messageRepository.findAll(); // select *
		model.addAttribute("messages", messages);
		return "message/listMessages"; // le chemin
	}
	

	// Suppression
	@GetMapping("/delete/{id}")
	public String deleteMessage(@PathVariable("id") int id) {
		messageRepository.deleteById(id); // delete
		return "redirect:../list";
	}

	@GetMapping("/update/{id}")
	public String getFormUpdateMessage(@PathVariable("id") int id, Model model) {
		Optional<Message> op_message = messageRepository.findById(id);
		Message message = op_message.get(); // la message trouvée dans la base
		model.addAttribute("message", message);
		return "message/updateMessage";
	}

	@PostMapping("/update")
	public String updateMessage(Message message) {
		messageRepository.save(message);  // save : insert
		return "redirect:list";
	}	
	
	
	@GetMapping("/findByDate")
	public String findByDate(@RequestParam("date") LocalDate date, Model model) {
		
		List<Message> messages = messageRepository.findByDateCreation(date);
		model.addAttribute("messages", messages);
		return "message/listMessages";
	}


/*
	@RequestMapping("/list")
	@ResponseBody
	public String getAllMessages() {
		List<Message> messages = (List<Message>) messageRepository.findAll(); // select *
		return messages.toString();
	}
	

	@RequestMapping("/delete/{id}")
	@ResponseBody
	public String deleteMessage(@PathVariable("id") int id) {
		messageRepository.deleteById(id); // delete
		List<Message> messages = (List<Message>) messageRepository.findAll();
		return messages.toString();
	}

	@RequestMapping("/update/{id}")
	@ResponseBody
	public String updateMessage(@PathVariable("id") int id) {
		Optional<Message> op_message = messageRepository.findById(id);
		Message message = op_message.get();

		message.setSujet("Test");
		message.setDescription("Alors, le test est réussi ?");
		message.setEmail("amine@gmail.com");
		message.setDate(LocalDateTime.now());

		// insertion dans la base de données de l'objet banque
		Message res = messageRepository.save(message); // save : update
		return res.toString();
	}

	*/

}
