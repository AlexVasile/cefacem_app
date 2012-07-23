package net.cefacem.app.dao;

import java.util.List;

import net.cefacem.app.model.Comment;

public interface CommentDAO extends GenericDAO<Comment, Long> {

	public List<Comment> findByPostId(long postId);
	public List<Comment> findByUserName(String userName);
}
