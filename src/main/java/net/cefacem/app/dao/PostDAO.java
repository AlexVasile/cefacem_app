package net.cefacem.app.dao;

import java.util.List;

import net.cefacem.app.model.Post;

public interface PostDAO extends GenericDAO<Post, Long> {
	
	public List<Post> findActivePosts();
	public List<Post> findInactivePosts();
}
