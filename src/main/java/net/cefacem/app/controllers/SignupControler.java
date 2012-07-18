package net.cefacem.app.controllers;

import java.util.Locale;

import javax.validation.Valid;

import net.cefacem.app.model.User;
import net.cefacem.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignupControler {
	
	@Autowired
	private UserService userService;
	@Autowired
	private MessageSource messages;
	
	@RequestMapping(value="signup", method=RequestMethod.GET)
	public String onGet(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@RequestMapping(value="signup", method=RequestMethod.POST)
	public String onSubmit(Model model, @Valid User newUser, BindingResult result, Locale loc) {
		if (result.hasErrors()) {
			return "signup";
		}
		else {
			if (userService.addUser(newUser)) {
				return "redirect:/";
			}
			else {
				model.addAttribute("userErrMessage", 
									messages.getMessage("signup.user.exists", null, loc));
				return "signup";
			}
		}
	}
}
