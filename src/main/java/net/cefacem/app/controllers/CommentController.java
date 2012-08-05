package net.cefacem.app.controllers;

import java.security.Principal;
import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.cefacem.app.model.Comment;
import net.cefacem.app.model.Post;
import net.cefacem.app.service.CommentService;
import net.cefacem.app.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommentController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	@Autowired
	private PostService postService;
	@Autowired
	private CommentService commentService;
	
	//post permalink and comments view
	@RequestMapping(value={"/posts/{id:\\d+}/comments", "/posts/{id:\\d+}"}, method=RequestMethod.GET)
	public String onGetComments(@PathVariable long id, Model model, Principal principal) {
		
		Post post = postService.findById(id);
		if (post != null) {
			model.addAttribute("logged_user", principal.getName());
			model.addAttribute("post", post);
			model.addAttribute("comments", commentService.findAllCommentsOfPost(id));
			model.addAttribute("comment", new Comment());
			return "comments_view";
		}
		else
			return "404";
	}
	
	//new comment posted
	@RequestMapping(value={"/posts/{postId:\\d+}/comments", "/posts/{postId:\\d+}"}, method=RequestMethod.POST)
	public String onPostComment(@PathVariable long postId, Model model, 
				@Valid Comment newComment, BindingResult result, Principal principal) {
		
		Post post = postService.findById(postId);
		if (post != null) {
			if (result.hasErrors()) {
				model.addAttribute("logged_user", principal.getName());
				model.addAttribute("post", post);
				model.addAttribute("comments", commentService.findAllCommentsOfPost(postId));
				return "comments_view";
			}
			else {
				commentService.addComment(newComment, principal.getName(), postId);
				return "redirect:/posts/" + postId;
			}
		}
		else 
			return "404";
	}
	
	//comment edit page
	@RequestMapping(value="/posts/{postId:\\d+}/comments/{commentId:\\d+}/edit",
					method=RequestMethod.GET)
	public String onGetCommentEdit(@PathVariable long postId, @PathVariable long commentId, 
									Model model, Principal principal) {
		
		Comment comment = commentService.findById(commentId);
		Post post = postService.findById(postId);
		if (comment != null && post != null && post.getPostId() == comment.getPost().getPostId()) {
			if (comment.getUser().getUserName().equals(principal.getName())) {
				model.addAttribute("logged_user", principal.getName());
				model.addAttribute("post", post);
				model.addAttribute("comments", commentService.findAllCommentsOfPost(postId));
				model.addAttribute("comment", comment);
				return "comment_edit";
			}
			else {
				logger.warn("NO Permission: " + principal.getName() + ". " + new Date().toString());
				return "redirect:/no_permission_to_edit";
			}
		}
		else 
			return "404";
	}
	
	//posting edited comment
	@RequestMapping(value="/posts/{postId:\\d+}/comments/{commentId:\\d+}/edit", 
						method=RequestMethod.POST)
	public String onPostCommentEdit(@PathVariable long postId, @PathVariable long commentId,
			Model model, Principal principal, @Valid Comment editedComment, BindingResult result) {
		
		Comment oldComment = commentService.findById(commentId);
		Post post = postService.findById(postId);
		if (oldComment != null && post != null && post.getPostId() == oldComment.getPost().getPostId()) {
			if (result.hasErrors()) {
				model.addAttribute("logged_user", principal.getName());
				model.addAttribute("post", post);
				model.addAttribute("comments", commentService.findAllCommentsOfPost(postId));
				return "comment_edit";
			}
			else {
				commentService.merge(oldComment, editedComment);
				return "redirect:/posts/" + postId + "/comments";
			}
		}
		else		
			return "404";
	}

	//comment permalink
	@RequestMapping(value="/posts/{postId:\\d+}/comments/{commentId:\\d+}", method=RequestMethod.GET)
	public String commentPermalink(@PathVariable long postId, @PathVariable long commentId, 
									Model model, Principal principal) {
		
		Comment comment = commentService.findById(commentId);
		if (comment != null) {
			model.addAttribute("comment", comment);
			model.addAttribute("logged_user", principal.getName());
			return "comment_view";
		}
		else 
			return "404";
	}
}
