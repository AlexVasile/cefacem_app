package net.cefacem.app.controllers;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import net.cefacem.app.model.Post;
import net.cefacem.app.service.PostService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PostController {
	
	private static final Logger logger = LoggerFactory.getLogger(PostController.class);
	
	@Autowired
	private PostService postService;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
	
	@RequestMapping(value="/post", method=RequestMethod.GET)
	public String onGetPostForm(Model model) {
		
		model.addAttribute("post", new Post());
		return "post";
	}
	
	@RequestMapping(value="/post", method=RequestMethod.POST)
	public String onSubmitPostForm(Model model, @Valid Post newPost,
					BindingResult result, Principal principal) {
		
		if (result.hasErrors()) {
			//validate the date of the event
			return "post";
		}
		else {
			long postId = postService.addPost(newPost, principal.getName());
			return "redirect:/posts/" + postId;
		}
	}
	
	@RequestMapping(value="/posts/{id:\\d+}/edit", method=RequestMethod.GET)
	public String editOnGet(@PathVariable long id, Model model, Principal principal) {
		
		Post post = postService.findById(id);
		if (post != null) {
			if (post.getUser().getUserName().equals(principal.getName())) {
				model.addAttribute("post", post);
				return "post_edit";
			}
			else {
				logger.warn("NO Permission: " + principal.getName() + ". " + new Date().toString());
				return "redirect:/no_permission_to_edit";
			}
		}
		else
			return "404";
	}
	
	@RequestMapping(value="/posts/{id:\\d+}/edit", method=RequestMethod.POST)
	public String editOnPost(@PathVariable long id, Model model, Principal principal,
								@Valid Post editedPost, BindingResult result) {
		
		Post oldPost = postService.findById(id);
		if (oldPost != null) {
			if (oldPost.getUser().getUserName().equals(principal.getName())) {
				if (result.hasErrors()) {
					return "post_edit";
				}
				else {
					postService.merge(oldPost, editedPost);
					return "redirect:/posts/" + id;
				}
			}
			else {
				logger.warn("NO Permission: " + principal.getName() + ". " + new Date().toString());
				return "redirect:/no_permission_to_edit";
			}
		}
		else
			return "404";
	}
}
