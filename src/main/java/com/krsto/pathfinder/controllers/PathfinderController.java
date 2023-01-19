package com.krsto.pathfinder.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.krsto.pathfinder.model.AbilityFactory.AbilityEnum;
import com.krsto.pathfinder.model.CharacterBuildInfo;
import com.krsto.pathfinder.model.CharacterSheet;

@Controller
public class PathfinderController {
	

	
	@PostMapping(path="/activate-ability")
	public ModelAndView activateAbility(@ModelAttribute("ability") AbilityEnum ability, HttpSession session) {
		
		CharacterSheet characterSheet = (CharacterSheet) session.getAttribute("character");
		
		if(characterSheet.isAbilityActive(ability)) {
			characterSheet.deactivateAbility(ability);
		}
		else {
			characterSheet.activateAbility(ability);
		}
		
		
		ModelAndView modelAndView = new ModelAndView("view.html")
				.addObject("character", characterSheet);
		
		
		return modelAndView;
	}
	
	
	
}
