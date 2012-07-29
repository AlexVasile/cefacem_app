package net.cefacem.app.service;

import java.util.List;

import net.cefacem.app.model.Comment;
import net.cefacem.app.model.Post;
import net.cefacem.app.model.User;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {
	
	public boolean addUser(User user);
	public void addOrUpdateUser(User user);
	public User merge(User user);
	public void delete(User user);
	public User findById(long id);
	public List<User> getAllUsers();
	public User findByUsername(String username);
	public List<Post> getAllUserPosts(String username);
	public List<Comment> getAllUserComments(String username);
}
