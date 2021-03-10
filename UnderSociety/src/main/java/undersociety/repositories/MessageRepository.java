package undersociety.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import undersociety.models.Message;
import undersociety.models.Users;

public interface MessageRepository extends JpaRepository<Message, Integer>{
	public List<Message> findByIduserAndIduserto(Users iduser,Users iduserto);
}
