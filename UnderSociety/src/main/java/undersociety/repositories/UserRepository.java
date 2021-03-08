package undersociety.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import undersociety.models.Users;


public interface UserRepository extends JpaRepository<Users, Integer>{
	
	public Optional<Users> findByusername(String username);
	
}
