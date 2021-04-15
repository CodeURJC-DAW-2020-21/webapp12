package undersociety.models;



import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;



@Entity
@Table(name = "users")
public class Users {
	
	public interface Basic{}
	public interface Detailed extends Users.Basic{}
	
	@JsonView(Basic.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idusers;
	@JsonView(Detailed.class)
	@Column
	private String email;
	@JsonView(Basic.class)
	@Column
	private String username;
	@JsonView(Detailed.class)
	@Column
	private String pass;
	@JsonView(Detailed.class)
	@Column
	private String name;
	@Lob
	@JsonIgnore
	private Blob userimg;
	@Column
	private boolean companyprofile;
	@Column
	private boolean userprofile;
	@JsonView(Detailed.class)
	@Column
	private String city;
	@Column
	private String userportimg;
	@JsonView(Detailed.class)
	@Column
	private String userinfo;
	@JsonView(Detailed.class)
	@Column
	private String linkfacebook;
	@JsonView(Detailed.class)
	@Column
	private String linktwitter;
	@JsonView(Detailed.class)
	@Column
	private String linkinstagram;
	@Lob
	@JsonIgnore
	private Blob imageprofile;
	
	
	public Users() {}
	public Users(String email, String username, String pass, String name, Blob userimg, boolean companyprofile,
			boolean userprofile, String city, String userportimg, String userinfo, String linkfacebook,
			String linktwitter, String linkinstagram, Blob imageprofile) {
		super();
		this.email = email;
		this.username = username;
		this.pass = pass;
		this.name = name;
		this.userimg = userimg;
		this.companyprofile = companyprofile;
		this.userprofile = userprofile;
		this.city = city;
		this.userportimg = userportimg;
		this.userinfo = userinfo;
		this.linkfacebook = linkfacebook;
		this.linktwitter = linktwitter;
		this.linkinstagram = linkinstagram;
		this.imageprofile = imageprofile;
	}
	public int getIdusers() {
		return idusers;
	}
	public void setIdusers(int idusers) {
		this.idusers = idusers;
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
	public Blob getImageprofile() {
		return imageprofile;
	}
	public void setImageprofile(Blob imageprofile) {
		this.imageprofile = imageprofile;
	}	
}
