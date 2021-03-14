package undersociety.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import undersociety.models.Roles;
import undersociety.models.Users;

public interface RolesRepository extends JpaRepository<Roles, Integer>{
	public List<Roles> findByiduser(Users iduser);
}
