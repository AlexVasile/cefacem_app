package net.cefacem.app.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import net.cefacem.app.model.Post;
import net.cefacem.app.service.PostService;
import net.cefacem.app.service.VoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class VoteController {
	
	@Autowired
	private VoteService voteService;
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/vote/{id:\\d+}/{voteType:up|down}", method=RequestMethod.POST)
	public String onVote(@PathVariable long id, @PathVariable String voteType,
							Principal principal, HttpServletRequest request) {
		
		Post post = postService.findById(id);
		if (post != null) {
			voteService.doVote(id, principal.getName(), voteType);
			String referer = request.getHeader("Referer");
			return "redirect:" + referer;
		}
		else
			return "404";
	}

}
