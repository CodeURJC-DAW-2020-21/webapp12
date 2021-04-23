package undersociety.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name="roles")
public class Roles {

	public interface Basic{}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idroles;
	@JsonView(Basic.class)
	@Column
	private String rol;
	@OneToOne
	@JoinColumn(name = "iduser", referencedColumnName = "idusers")
	private Users iduser;
	
	
	public Roles() {}
	public Roles(String rol, Users iduser) {
		super();
		this.rol = rol;
		this.iduser = iduser;
	}
	public int getIdroles() {
		return idroles;
	}
	public void setIdroles(int idroles) {
		this.idroles = idroles;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public Users getIduser() {
		return iduser;
	}
	public void setIduser(Users iduser) {
		this.iduser = iduser;
	}
}
