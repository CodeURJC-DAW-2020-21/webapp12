package undersociety.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import undersociety.models.Users;
import undersociety.repositories.UserRepository;


@Service
public class UserService implements ServiceInterface{
	@Autowired
	private UserRepository data;
	
	@Override
	public List<Users> load() {
		List<Users> load = (List<Users>) data.findAll();
		return load;
	}

	@Override
	public int save(Object p) {
		Users s = (Users) p;
		data.save(s);
		return 0;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}

	@Override
	public boolean existsById(int id) {
		return data.existsById(id);
	}

	@Override
	public Users findById(int id) {
		return data.findById(id).get();
	}

	@Override
	public Object findByUser_name(String username) {
		return data.findByusername(username).get();
	}

	@Override
	public boolean findByUser_nameExists(String username) {
		return data.findByusername(username).isPresent();
	}
}
