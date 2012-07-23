package net.cefacem.app.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface VoteService {
	
	public int doVote(long postId, String userName, String voteType);
}
