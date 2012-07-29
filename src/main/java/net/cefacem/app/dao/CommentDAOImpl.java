package net.cefacem.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import net.cefacem.app.model.Comment;

@Repository
public class CommentDAOImpl extends GenericDAOImpl<Comment, Long> implements CommentDAO {

	@Override
	protected Class<Comment> getEntityClass() {
		return Comment.class;
	}

	@SuppressWarnings("unchecked")
	public List<Comment> findByPostId(long postId) {
		Query query = getSession().createQuery("from Comment where post.postId = :postId");
		query.setParameter("postId", postId);
		query.setCacheable(true);
		return (List<Comment>) query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Comment> findByUserName(String userName) {
		Query query = getSession().createQuery("from Comment where user.userName = :userName");
		query.setParameter("userName", userName);
		query.setCacheable(true);
		return (List<Comment>) query.list();

	}
}
