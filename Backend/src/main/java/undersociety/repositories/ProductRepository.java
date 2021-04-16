package undersociety.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import undersociety.models.Product;
import undersociety.models.Tags;
import undersociety.models.Users;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	public Page<Product> findByiduser(Users iduser, Pageable page);	
	public Long deleteByIduser(Users iduser);
	public List<Product> findByidtagone(Tags idtagone);
	public List<Product> findByidtagtwo(Tags idtagtwo);
	public List<Product> findByidtagthree(Tags idtagthree);
	public List<Product> findByidtagfour(Tags idtagfour);
	public List<Product> findByidtagfive(Tags idtagfive);
	public List<Product> findBystatus(String status);
	public Product findBytitle (String title);
	public Optional<Product> findBydescription (String description);
	public List<Product> findByiduser(Users user);
	public boolean existsIdproductByTitle(String title);
	
}
