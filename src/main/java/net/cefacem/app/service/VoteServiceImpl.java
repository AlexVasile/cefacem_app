package net.cefacem.app.service;

import net.cefacem.app.dao.PostDAO;
import net.cefacem.app.dao.UserDAO;
import net.cefacem.app.dao.VoteDAO;
import net.cefacem.app.model.Post;
import net.cefacem.app.model.User;
import net.cefacem.app.model.Vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	private VoteDAO voteDao;
	@Autowired
	private PostDAO postDao;
	@Autowired
	private UserDAO userDao;
	

	public int doVote(long postId, String userName, String voteType) {
		Vote vote = voteDao.findByPostAndUser(postId, userName, voteType);
		Post post = postDao.findById(postId);
		if (vote == null) {
			User user = userDao.findByUsername(userName);
			Vote newVote = new Vote();
			newVote.setPost(post);
			newVote.setUser(user);
			newVote.setVoteType(voteType);
			voteDao.save(newVote);
			//same session => post is persistent object
			if (voteType.equals(Vote.VOTE_UP)) {
				post.setVotesUp(post.getVotesUp() + 1);
				post.setSimpleScore(post.getSimpleScore() + 1);
				//calculate new score for post ranking
			}
			else if (voteType.equals(Vote.VOTE_DOWN)) {
				post.setVotesDown(post.getVotesDown() + 1);
				post.setSimpleScore(post.getSimpleScore() - 1);
				//calculate new score
			}
			
			return post.getSimpleScore();
		}
		else {
			//if the vote existed => delete (undo the vote)
			voteDao.delete(vote);
			if (voteType.equals(Vote.VOTE_UP)) {
				post.setVotesUp(post.getVotesUp() - 1);
				post.setSimpleScore(post.getSimpleScore() - 1);
				//calculate score
			}
			else if (voteType.equals(Vote.VOTE_DOWN)) {
				post.setVotesDown(post.getVotesDown() - 1);
				post.setSimpleScore(post.getSimpleScore() + 1);
				//calculate score
			}
			
			return post.getSimpleScore();
		}
	}

}
