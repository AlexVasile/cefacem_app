package net.cefacem.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name="VOTES")
public class Vote {
	
	public static final String VOTE_UP = "up";
	public static final String VOTE_DOWN = "down";

	private long voteId;
	private User user;
	private Post post;
	private String voteType;
	
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="vote_id")
	public long getVoteId() {
		return voteId;
	}
	public void setVoteId(long voteId) {
		this.voteId = voteId;
	}
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable = false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne
	@JoinColumn(name="post_id", nullable = false)
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	@Column(name="vote_type")
	public String getVoteType() {
		return voteType;
	}
	public void setVoteType(String voteType) {
		this.voteType = voteType;
	}	
	
}
