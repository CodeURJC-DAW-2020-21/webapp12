package undersociety.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import undersociety.models.Users;
import undersociety.models.UsersRelations;

public interface UsersRelationsRepository extends JpaRepository<UsersRelations, Integer>{
	public List<UsersRelations> findByuserone(Users userone);
	public List<UsersRelations> findByusertwo(Users usertwo);
	public UsersRelations findByuseroneAndUsertwo(Users userone, Users usertwo);
	public Long deleteByUserone(Users userone);
}
