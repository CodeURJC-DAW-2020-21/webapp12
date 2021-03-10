package undersociety.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


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
	@Column
	private String user_img;
	@Column
	private boolean company_profile;
	@Column
	private boolean user_profile;
	@Column
	private String city;
	@Column
	private String user_port_img;
	@Column
	private String user_info;
	@Column
	private String link_facebook;
	@Column
	private String link_twitter;
	@Column
	private String link_instagram;
	
	public int getId_users() {
		return idusers;
	}
<<<<<<< develop
	public void setId_users(int id_users) {
		this.idusers = id_users;
=======
	public void setId_users(int idusers) {
		this.idusers = idusers;
>>>>>>> Implemented chat function
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser_name() {
		return username;
	}
	public void setUser_name(String user_name) {
		this.username = user_name;
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
	public String getUser_img() {
		return user_img;
	}
	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}
	public boolean getCompany_profile() {
		return company_profile;
	}
	public void setCompany_profile(boolean company_profile) {
		this.company_profile = company_profile;
	}
	public boolean getUser_profile() {
		return user_profile;
	}
	public void setUser_profile(boolean user_profile) {
		this.user_profile = user_profile;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUser_port_img() {
		return user_port_img;
	}
	public void setUser_port_img(String user_port_img) {
		this.user_port_img = user_port_img;
	}
	public String getUser_info() {
		return user_info;
	}
	public void setUser_info(String user_info) {
		this.user_info = user_info;
	}
	public String getLink_facebook() {
		return link_facebook;
	}
	public void setLink_facebook(String link_facebook) {
		this.link_facebook = link_facebook;
	}
	public String getLink_twitter() {
		return link_twitter;
	}
	public void setLink_twitter(String link_twitter) {
		this.link_twitter = link_twitter;
	}
	public String getLink_instagram() {
		return link_instagram;
	}
	public void setLink_instagram(String link_instagram) {
		this.link_instagram = link_instagram;
	}
}
