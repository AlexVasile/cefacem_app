package net.cefacem.app.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@Autowired
	MessageSource messages;
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String onGet(@RequestParam(value="error", required=false) boolean error,
						Model model, Locale loc) {
		
		if (error == true) {
			model.addAttribute("error", messages.getMessage("login.error", null, loc));
		} 
		else {
			model.addAttribute("error", "");
		}
		return "login";
	}
	
}
