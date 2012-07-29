package net.cefacem.app.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import net.cefacem.app.dao.PostDAO;
import net.cefacem.app.dao.UserDAO;
import net.cefacem.app.model.Post;
import net.cefacem.app.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostDAO postDao;
	@Autowired 
	private UserDAO userDao;
	@Autowired
	private PostSimpleComparator simpleComp;

	public long addPost(Post post, String creatorUserName) {
		User user = userDao.findByUsername(creatorUserName);
		post.setUser(user);
		return postDao.save(post);
	}

	public void addOrUpdatePost(Post post) {
		postDao.saveOrUpdate(post);		
	}

	public Post merge(Post oldPost, Post editedPost) {
		oldPost.setLastEdited(new Date());
		oldPost.setContent(editedPost.getContent());
		oldPost.setEventDateTime(editedPost.getEventDateTime());
		return postDao.merge(oldPost);
	}

	public void delete(Post post) {
		postDao.delete(post);
	}

	public Post findById(long id) {
		return postDao.findById(id);
	}

	public List<Post> findAllPosts() {
		List<Post> allPosts = postDao.findAll();
		//calculate score for every post
		
		Collections.sort(allPosts, simpleComp);
		return allPosts;
	}

}
