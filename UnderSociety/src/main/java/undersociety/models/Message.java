package undersociety.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message  implements Comparable<Message>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idmessage;
	@OneToOne
	@JoinColumn(name = "iduser", referencedColumnName = "idusers")
	private Users iduser;
	@OneToOne
	@JoinColumn(name = "iduserto", referencedColumnName = "idusers")
	private Users iduserto;
	@Column
	private String message;
	@Column
	private String time;
	
	
	
	public Message() {}
	public Message(Users iduser, Users iduserto, String message, String time) {
		super();
		this.iduser = iduser;
		this.iduserto = iduserto;
		this.message = message;
		this.time = time;
	}
	public int getIdmessage() {
		return idmessage;
	}
	public void setIdmessage(int idmessage) {
		this.idmessage = idmessage;
	}
	public Users getIduser() {
		return iduser;
	}
	public void setIduser(Users iduser) {
		this.iduser = iduser;
	}
	public Users getIduserto() {
		return iduserto;
	}
	public void setIduserto(Users iduserto) {
		this.iduserto = iduserto;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public int compareTo(Message u) {
		if (getIdmessage() == 0 || u.getIdmessage() == 0) {
		      return 0;
		    }
		    return (getIdmessage() - u.getIdmessage());
	}
	
	
}
