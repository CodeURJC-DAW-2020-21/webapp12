package undersociety.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import undersociety.models.Users;


public interface UserRepository extends JpaRepository<Users, Integer>{
	
	public Optional<Users> findByusername(String username);
	public List<Users> findByuserprofile(boolean userprofile);
	public List<Users> findBycompanyprofile(boolean companyprofile);
	public Page<Users> findByuserprofile(boolean userprofile, Pageable page);
	public Page<Users> findBycompanyprofile(boolean companyprofile, Pageable page);
}
