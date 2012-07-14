package net.cefacem.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="COMMENTS")
public class Comment {
	
	private int commentId;
	private User user;
	private Post post;
	private String content;
	private Date creationDate;
	private Date lastEdited;
	private int votesUp;
	
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="comment_id")
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="user_id", nullable = false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="post_id", nullable = false)
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	@Lob
	@Column (nullable = false)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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

}
