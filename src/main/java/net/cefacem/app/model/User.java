package net.cefacem.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table (name="USERS")
public class User {
		
	private int userId;
	private String userName;
	private String email;
	private String password;
	private Date creationDate = new Date();
	private List<Post> postsList = new ArrayList<Post>();
	private List<Comment> commentsList = new ArrayList<Comment>();
	
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="user_id")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column (name="username", nullable = false, length = 30, unique=true)
	@NotBlank(message="{validation.notblank}")
	@Length(min=3, max=30, message="{validation.username.length}")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column (nullable = false)
	@NotBlank(message="{validation.notblank}")
	@Length(min=6,  message="{validation.password.length}")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column (nullable = false, length = 50)
	@NotBlank(message="{validation.notblank}")
	@Email(message="{validation.email.format}")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column (name="creation_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	@OneToMany (mappedBy="user")
	public List<Post> getPostsList() {
		return postsList;
	}
	public void setPostsList(List<Post> postsList) {
		this.postsList = postsList;
	}
	
	@OneToMany (mappedBy="user")
	public List<Comment> getCommentsList() {
		return commentsList;
	}
	public void setCommentsList(List<Comment> commentsList) {
		this.commentsList = commentsList;
	}
	
}
