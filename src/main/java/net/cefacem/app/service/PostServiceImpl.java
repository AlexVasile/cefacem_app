package net.cefacem.app.service;

import java.util.List;

import net.cefacem.app.dao.PostDAO;
import net.cefacem.app.model.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostDAO postDao;

	public int addPost(Post post) {
		return postDao.save(post);
	}

	public void addOrUpdatePost(Post post) {
		postDao.saveOrUpdate(post);		
	}

	public Post merge(Post post) {
		return postDao.merge(post);
	}

	public void delete(Post post) {
		postDao.delete(post);
	}

	public Post findById(int id) {
		return postDao.findById(id);
	}

	public List<Post> findAllPosts() {
		return postDao.findAll();
	}

}
