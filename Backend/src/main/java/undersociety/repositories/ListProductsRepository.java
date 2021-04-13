package undersociety.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import undersociety.models.ListProducts;
import undersociety.models.Product;
import undersociety.models.Users;

public interface ListProductsRepository extends JpaRepository<ListProducts, Integer>{
	public List<ListProducts> findByiduser(Users iduser);
	public ListProducts findByiduserAndIdproduct(Users iduser, Product idproduct);
	public Long deleteByIduser(Users iduser);
	public Long deleteByIdproduct (Product idproduct);
	
}
