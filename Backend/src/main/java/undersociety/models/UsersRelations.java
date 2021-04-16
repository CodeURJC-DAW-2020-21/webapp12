package undersociety.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;



@Entity
@Table(name="user_relation")
public class UsersRelations {
	
	public interface Basic extends Users.Basic{}
	
	@JsonView(Basic.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iduserrelation;
	@JsonView(Basic.class)
	@OneToOne
	@JoinColumn(name = "userone", referencedColumnName = "idusers")
	private Users userone;
	@JsonView(Basic.class)
	@OneToOne
	@JoinColumn(name = "usertwo", referencedColumnName = "idusers")
	private Users usertwo;
	
	
	public UsersRelations() {}
	public UsersRelations(Users userone, Users usertwo) {
		super();
		this.userone = userone;
		this.usertwo = usertwo;
	}
	public int getIduserrelation() {
		return iduserrelation;
	}
	public void setIduserrelation(int iduserrelation) {
		this.iduserrelation = iduserrelation;
	}
	public Users getUserone() {
		return userone;
	}
	public void setUserone(Users userone) {
		this.userone = userone;
	}
	public Users getUsertwo() {
		return usertwo;
	}
	public void setUsertwo(Users usertwo) {
		this.usertwo = usertwo;
	}
	
	
}
