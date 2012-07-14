package net.cefacem.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

@Entity
@Table (name="POSTS")
public class Post {

	private int postId;
	private User user;
	private String content;
	private Date eventDate;
	private Date eventTime;
	private Date creationDate = new Date();
	private Date lastEdited;
	private int votesUp;
	private int votesDown;
	private double score;
	private List<Comment> commentsList = new ArrayList<Comment>();
	
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="post_id")
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Lob
	@Column (nullable = false)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column (name="event_date")
	@Temporal(TemporalType.DATE)
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	
	@Column (name="event_time")
	@Temporal(TemporalType.TIME)
	public Date getEventTime() {
		return eventTime;
	}
	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
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
	
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	@OneToMany (mappedBy="post")
	public List<Comment> getCommentsList() {
		return commentsList;
	}
	public void setCommentsList(List<Comment> commentsList) {
		this.commentsList = commentsList;
	}
	
}
