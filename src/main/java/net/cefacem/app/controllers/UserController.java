package net.cefacem.app.controllers;

import java.security.Principal;
import java.util.Date;

import net.cefacem.app.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/{name:^.{3,30}$}", method=RequestMethod.GET)
	public String userPage(@PathVariable String name, Model model, Principal principal) {
		if (!principal.getName().equals(name)) {
			logger.warn("NO Permission: " + principal.getName() + ". " + new Date().toString());
			return "no_permission_to_edit";
		}
		else {
			model.addAttribute("user", userService.findByUsername(name));
			model.addAttribute("user_posts", userService.getAllUserPosts(name));
			model.addAttribute("user_comments", userService.getAllUserComments(name));
			return "user";
		}
	}
}
