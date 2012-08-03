package net.cefacem.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LanguageController {
	
	@RequestMapping(value="/change_language", method=RequestMethod.GET)
	public String changeLanguage(HttpServletRequest request) {
		String referer = request.getHeader("Referer");
	    return "redirect:" + referer;
	}
}
