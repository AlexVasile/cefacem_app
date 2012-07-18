package net.cefacem.app.controllers;

import java.security.Principal;
import java.util.List;

import net.cefacem.app.model.Post;
import net.cefacem.app.service.PostService;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private PostService postService;

	@RequestMapping(value = {"/", "index", "home"}, method = RequestMethod.GET)
	public String home(Model model, Principal principal) {	
		
		if (principal != null)
			model.addAttribute("logged_user", principal.getName());
		List<Post> posts = postService.findAllPosts();
		model.addAttribute("posts", posts);
		
		return "home";
	}
	
}
