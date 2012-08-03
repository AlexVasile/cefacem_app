package net.cefacem.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import net.cefacem.app.model.Post;

@Repository
public class PostDAOImpl extends GenericDAOImpl<Post, Long> implements PostDAO {

	@Override
	protected Class<Post> getEntityClass() {
		return Post.class;
	}

	@SuppressWarnings("unchecked")
	public List<Post> findActivePosts() {
		Query query = getSession().createQuery("from Post where active = true");
		query.setCacheable(true);
		return (List<Post>) query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Post> findInactivePosts() {
		Query query = getSession().createQuery("from Post where active = false");
		query.setCacheable(true);
		return (List<Post>) query.list();
	}
}
