package com.krsto.pathfinder.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.krsto.pathfinder.model.CharacterBuildInfo;
import com.krsto.pathfinder.model.CharacterSheet;
import com.krsto.pathfinder.repositories.ItemRepository;
import com.krsto.pathfinder.model.CharacterClassFactory.CharacterClassEnum;


@Controller
public class CharacterCreationController {
	


	@GetMapping(path={"/home", "", "/" })
	public ModelAndView get() {
		
		ModelAndView modelAndView = new ModelAndView("character-creation.html");
		modelAndView.addObject("weapons", ItemRepository.getWeapons());
		return modelAndView;
	}
	
	@PostMapping(path="/character")
	public ModelAndView createCharacter(@ModelAttribute CharacterBuildInfo buildInfo, HttpSession session) {
		
		ModelAndView mav = new ModelAndView("view.html");
		
		CharacterSheet characterSheet = new CharacterSheet();
		
		characterSheet.initialize(buildInfo);
		
		mav.addObject("character", characterSheet);
		
		session.setAttribute("character", characterSheet);
		
		return mav;

	}
	
}
