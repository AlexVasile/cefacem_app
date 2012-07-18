package net.cefacem.app.service;

import java.util.List;

import net.cefacem.app.model.Post;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PostService {
	
	public int addPost(Post post);
	public void addOrUpdatePost(Post post);
	public Post merge(Post post);
	public void delete(Post post);
	public Post findById(int id);
	public List<Post> findAllPosts();
	
	
}
