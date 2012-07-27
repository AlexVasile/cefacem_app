package net.cefacem.app.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import net.cefacem.app.model.User;
import net.cefacem.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignupController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private MessageSource messages;
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;
	
	@RequestMapping(value="signup", method=RequestMethod.GET)
	public String onGet(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@RequestMapping(value="signup", method=RequestMethod.POST)
	public String onSubmit(Model model, @Valid User newUser, BindingResult result, Locale loc,
							HttpServletRequest request) {
		
		//keep the password in raw for authentication, after the user is added in DB
		User u = new User();
		u.setUserName(newUser.getUserName());
		u.setPassword(newUser.getPassword());
		
		if (result.hasErrors()) {
			return "signup";
		}
		else {
			if (userService.addUser(newUser)) {
				//authenticate the new user
				authenticateUserAndSetSession(u, request);
				return "redirect:/home";
			}
			else {
				model.addAttribute("userErrMessage", 
									messages.getMessage("signup.user.exists", null, loc));
				return "signup";
			}
		}
	}
	
	private void authenticateUserAndSetSession(User user, HttpServletRequest request) {
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
	            user.getUserName(), user.getPassword());
		request.getSession();
		token.setDetails(new WebAuthenticationDetails(request));
		try {
			Authentication authenticatedUser = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
		}
		catch (AuthenticationException e) {
			e.printStackTrace();
		}
	}
}
