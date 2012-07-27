package net.cefacem.app.service;

import java.util.List;

import net.cefacem.app.model.Post;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PostService {
	
	public long addPost(Post post, String creatorUserName);
	public void addOrUpdatePost(Post post);
	public Post merge(Post oldPost, Post editedPost);
	public void delete(Post post);
	public Post findById(long id);
	public List<Post> findAllPosts();
	public List<Post> findAllPostsOfUser(String userName);
	
}
