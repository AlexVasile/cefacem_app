package net.cefacem.app.dao;

import org.springframework.stereotype.Repository;

import net.cefacem.app.model.Comment;

@Repository
public class CommentDAOImpl extends GenericDAOImpl<Comment, Integer> implements CommentDAO {

	@Override
	protected Class<Comment> getEntityClass() {
		return Comment.class;
	}
}
