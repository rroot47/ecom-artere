package product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import product.entities.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}
