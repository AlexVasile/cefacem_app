package net.cefacem.app.controllers;

import java.security.Principal;
import java.util.List;

import net.cefacem.app.model.Post;
import net.cefacem.app.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private PostService postService;
	private final int PAGE_LENGTH = 5;

	@RequestMapping(value = {"/", "/index", "/home"}, method = RequestMethod.GET)
	public String home(Model model, Principal principal) {	
		
		if (principal != null)
			model.addAttribute("logged_user", principal.getName());
		List<Post> posts = postService.findAllPosts();
		int n = posts.size();
		if (n < PAGE_LENGTH) { 
			model.addAttribute("posts", posts.subList(0, n));
			model.addAttribute("prev", "n");
			model.addAttribute("next", "n");
		}
		else {
			model.addAttribute("posts", posts.subList(0, PAGE_LENGTH));
			model.addAttribute("prev", "n");
			model.addAttribute("next", "y");
			model.addAttribute("next_start", PAGE_LENGTH);
			model.addAttribute("page_length", PAGE_LENGTH);
		}
		return "home";
	}
	
	@RequestMapping(value = {"/page"}, method = RequestMethod.GET)
	public String home2(@RequestParam int start, @RequestParam int end, 
						Model model, Principal principal) {	
		
		if (principal != null)
			model.addAttribute("logged_user", principal.getName());
		List<Post> posts = postService.findAllPosts();
		int n = posts.size();
		
		if (start <= 0) {
			start = 0;
			model.addAttribute("prev", "n");
		} 
		else if (start >= n) {
			return "404";
		}
		else {
			model.addAttribute("prev", "y");
			model.addAttribute("prev_end", start);
		}
		
		if (end < 0) {
			return "404";
		}
		else if (end >= n) {
			end = n;
			model.addAttribute("next", "n");
		}
		else {
			model.addAttribute("next", "y");
			model.addAttribute("next_start", end);
		}
		
		model.addAttribute("page_length", PAGE_LENGTH);	
		model.addAttribute("posts", posts.subList(start, end));
		
		return "home";
	}
}
