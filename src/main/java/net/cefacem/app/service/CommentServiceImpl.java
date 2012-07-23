package net.cefacem.app.service;

import java.util.Date;
import java.util.List;

import net.cefacem.app.dao.CommentDAO;
import net.cefacem.app.dao.PostDAO;
import net.cefacem.app.dao.UserDAO;
import net.cefacem.app.model.Comment;
import net.cefacem.app.model.Post;
import net.cefacem.app.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDAO commentDao;
	@Autowired
	private PostDAO postDao;
	@Autowired
	private UserDAO userDao;

	public long addComment(Comment comment, String creatorUserName, long postId) {
		User user = userDao.findByUsername(creatorUserName);
		Post post = postDao.findById(postId);
		comment.setUser(user);
		comment.setPost(post);
		return commentDao.save(comment);
	}

	public void addOrUpdateComment(Comment comment) {
		commentDao.saveOrUpdate(comment);		
	}

	public Comment merge(Comment oldComment, Comment editedComment) {
		oldComment.setContent(editedComment.getContent());
		oldComment.setLastEdited(new Date());
		return commentDao.merge(oldComment);
	}

	public void delete(Comment comment) {
		commentDao.delete(comment);
	}

	public Comment findById(long id) {
		return commentDao.findById(id);
	}

	public List<Comment> findAllCommentsOfPost(long postId) {
		return commentDao.findByPostId(postId);
	}

	public List<Comment> findAllCommentsOfUser(String userName) {
		return commentDao.findByUserName(userName);
	}
}
