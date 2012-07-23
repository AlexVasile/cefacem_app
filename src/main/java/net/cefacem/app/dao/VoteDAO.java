package net.cefacem.app.dao;

import net.cefacem.app.model.Vote;

public interface VoteDAO extends GenericDAO<Vote, Long> {
	
	public Vote findByPostAndUser(long postId, String userName, String voteType);

}
