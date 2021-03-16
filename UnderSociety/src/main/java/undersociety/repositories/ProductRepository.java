package undersociety.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import undersociety.models.Product;
import undersociety.models.Users;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	public Page<Product> findByiduser(Users iduser, Pageable page);
	public Long deleteByIduser(Users iduser);
}
