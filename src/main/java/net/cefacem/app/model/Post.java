package net.cefacem.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name="POSTS")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Post {

	private long postId;
	private User user;
	private String content;
	private Date eventDateTime;	
	private int votesUp = 0;
	private int votesDown = 0;
	private int simpleScore = 0;  //votesUp - votesDown
	private double score = 0;
	private boolean active = true;
	private Date creationDate = new Date();
	private Date lastEdited;
	private List<Comment> commentsList = new ArrayList<Comment>();
	private List<Vote> votesList = new ArrayList<Vote>();
	
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="post_id")
	public long getPostId() {
		return postId;
	}
	public void setPostId(long postId) {
		this.postId = postId;
	}
	
	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Lob
	@Column (nullable = false)
	@NotEmpty(message="{validation.notblank}")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column (name="event_date_time", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull(message="{validation.notblank}")
	public Date getEventDateTime() {
		return eventDateTime;
	}
	public void setEventDateTime(Date eventDateTime) {
		this.eventDateTime = eventDateTime;
	}
	
	@Column (name="creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	@Column (name="last_edited")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getLastEdited() {
		return lastEdited;
	}
	public void setLastEdited(Date lastEdited) {
		this.lastEdited = lastEdited;
	}
	
	@Column (name="votes_up")
	public int getVotesUp() {
		return votesUp;
	}
	public void setVotesUp(int votesUp) {
		this.votesUp = votesUp;
	}
	
	@Column (name="votes_down")
	public int getVotesDown() {
		return votesDown;
	}
	public void setVotesDown(int votesDown) {
		this.votesDown = votesDown;
	}
	
	@Column (name="simple_score")
	public int getSimpleScore() {
		return simpleScore;
	}
	public void setSimpleScore(int simpleScore) {
		this.simpleScore = simpleScore;
	}
	
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	@Column (name="active")
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	@OneToMany (mappedBy="post")
	public List<Comment> getCommentsList() {
		return commentsList;
	}
	public void setCommentsList(List<Comment> commentsList) {
		this.commentsList = commentsList;
	}
	
	@OneToMany (mappedBy="post")
	public List<Vote> getVotesList() {
		return votesList;
	}
	public void setVotesList(List<Vote> votesList) {
		this.votesList = votesList;
	}
	
}
