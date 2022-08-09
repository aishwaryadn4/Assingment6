package com.springbootcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbootcrud.model.Player;
import com.springbootcrud.service.PlayerService;

@Controller
public class PlayerController {
	
	@Autowired
	
	private PlayerService playerService;
	//Display LIst of players
	
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listPlayers",playerService.getAllPlayers());
		return "index";
	}
	
	@GetMapping("/showNewPlayerForm")
    public String ShowNewPlayerForm(Model model) {
 
		Player player=new Player();
		model.addAttribute("player",player);
		return"new_playerForm";
}
	@PostMapping("/savePlayer")
	public String SavePlayer(@ModelAttribute("payer") Player player) {
		
		playerService.savePlayer(player);
		
		return "redirect:/";	 
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String ShowFormForUpdate(@PathVariable (value="id") long id,Model model) {
		
		Player player=playerService.getPlayerById(id);
	    model.addAttribute("player",player);
	    return "update_player";
	}
	
	@GetMapping("/DeletePlayer/{id}")
	public String deletePlayerById(@PathVariable (value="id") long id) {
		
	this.playerService.deletePlayerById(id);
	
	return "redirect:/";
		
	}
	
	
}