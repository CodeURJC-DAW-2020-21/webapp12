package undersociety.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import undersociety.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
