package net.cefacem.app.dao;

import org.springframework.stereotype.Repository;

import net.cefacem.app.model.Post;

@Repository
public class PostDAOImpl extends GenericDAOImpl<Post, Integer> implements PostDAO {

	@Override
	protected Class<Post> getEntityClass() {
		return Post.class;
	}
}
