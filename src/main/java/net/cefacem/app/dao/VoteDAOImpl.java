package net.cefacem.app.dao;

import net.cefacem.app.model.Vote;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class VoteDAOImpl extends GenericDAOImpl<Vote, Long> implements VoteDAO {

	@Override
	protected Class<Vote> getEntityClass() {
		return Vote.class;
	}

	public Vote findByPostAndUser(long postId, String userName, String voteType) {
		Query query = getSession().createQuery("from Vote where post.postId = :postId" +
							" and user.userName = :userName and voteType = :voteType");
		query.setParameter("postId", postId);
		query.setParameter("userName", userName);
		query.setParameter("voteType", voteType);
		return (Vote) query.uniqueResult();
	}

}
