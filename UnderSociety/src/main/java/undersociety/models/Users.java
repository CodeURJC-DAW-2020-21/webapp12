package undersociety.models;



import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "users")
public class Users {
	@Id
	@Column
	private int idusers;
	@Column
	private String email;
	@Column
	private String username;
	@Column
	private String pass;
	@Column
	private String name;
	@Lob
	@JsonIgnore
	private Blob userimg;
	@Column
	private boolean companyprofile;
	@Column
	private boolean userprofile;
	@Column
	private String city;
	@Column
	private String userportimg;
	@Column
	private String userinfo;
	@Column
	private String linkfacebook;
	@Column
	private String linktwitter;
	@Column
	private String linkinstagram;
	
	public int getIdusers() {
		return idusers;
	}
<<<<<<< develop
<<<<<<< develop
<<<<<<< HEAD
=======
<<<<<<< develop
>>>>>>> SpringAppPostsAndProducts
	public void setId_users(int id_users) {
		this.idusers = id_users;
=======
	public void setId_users(int idusers) {
=======
	public void setIdusers(int idusers) {
>>>>>>> Fixes in INdex.html
		this.idusers = idusers;
>>>>>>> Implemented chat function
=======
	public void setId_users(int idusers) {
		this.idusers = idusers;
<<<<<<< HEAD
>>>>>>> Implemented Email functions in App
=======
>>>>>>> fixes to posts and product
>>>>>>> SpringAppPostsAndProducts
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Blob getUserimg() {
		return userimg;
	}
	public void setUserimg(Blob userimg) {
		this.userimg = userimg;
	}
	public boolean getCompanyprofile() {
		return companyprofile;
	}
	public void setCompanyprofile(boolean companyprofile) {
		this.companyprofile = companyprofile;
	}
	public boolean getUserprofile() {
		return userprofile;
	}
	public void setUserprofile(boolean userprofile) {
		this.userprofile = userprofile;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUserportimg() {
		return userportimg;
	}
	public void setUserportimg(String userportimg) {
		this.userportimg = userportimg;
	}
	public String getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}
	public String getLinkfacebook() {
		return linkfacebook;
	}
	public void setLinkfacebook(String linkfacebook) {
		this.linkfacebook = linkfacebook;
	}
	public String getLinktwitter() {
		return linktwitter;
	}
	public void setLinktwitter(String linktwitter) {
		this.linktwitter = linktwitter;
	}
	public String getLinkinstagram() {
		return linkinstagram;
	}
	public void setLinkinstagram(String linkinstagram) {
		this.linkinstagram = linkinstagram;
	}
}
