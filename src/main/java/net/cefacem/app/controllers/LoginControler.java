package net.cefacem.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginControler {
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String onGet(@RequestParam(value="error", required=false) boolean error, Model model) {
		
		if (error == true) {
			model.addAttribute("error", "Logare invalida");
		} 
		else {
			model.addAttribute("error", "");
		}
		return "login";
	}
	
}
