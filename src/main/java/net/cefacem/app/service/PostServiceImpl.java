package net.cefacem.app.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import net.cefacem.app.dao.PostDAO;
import net.cefacem.app.dao.UserDAO;
import net.cefacem.app.model.Post;
import net.cefacem.app.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostDAO postDao;
	@Autowired 
	private UserDAO userDao;
	@Autowired
	private PostComparatorBySimpleScore simpleComp;
	@Autowired
	private PostComparatorByDate dateComp;

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
		return postDao.findAll();
	}
	
	@Scheduled(fixedDelay=60000) // 1 minutes
	public void updateScores() {
		System.out.println("update the score");
		List<Post> posts = postDao.findActivePosts();
		Date now = new Date();
		for (Post p : posts)
			if(p.getEventDateTime().before(now)) 
				p.setActive(false);
			else {
				//update score
				
			}
	}

	@Override
	public List<Post> findActivePosts() {
		List<Post> activePosts = postDao.findActivePosts();
		Collections.sort(activePosts, simpleComp);
		return activePosts;
	}

	@Override
	public List<Post> findInactivePosts() {
		List<Post> inactivePosts = postDao.findInactivePosts();
		Collections.sort(inactivePosts, dateComp);
		return inactivePosts;
	}
}
