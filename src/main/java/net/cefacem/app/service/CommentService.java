package net.cefacem.app.service;

import java.util.List;

import net.cefacem.app.model.Comment;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CommentService {

	public long addComment(Comment comment, String creatorUserName, long postId);
	public void addOrUpdateComment(Comment comment);
	public Comment merge(Comment oldComment, Comment editedComment);
	public void delete (Comment comment);
	public Comment findById(long id);
	public List<Comment> findAllCommentsOfPost(long postId);
	public List<Comment> findAllCommentsOfUser(String userName);
}
