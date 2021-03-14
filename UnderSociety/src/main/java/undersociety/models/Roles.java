package undersociety.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Roles {

	@Id
	@Column
	private int idroles;
	@Column
	private String rol;
	@OneToOne
	@JoinColumn(name = "iduser", referencedColumnName = "idusers")
	private Users iduser;

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
