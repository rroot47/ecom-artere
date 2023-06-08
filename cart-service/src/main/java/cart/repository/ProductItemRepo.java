package cart.repository;

import cart.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductItemRepo extends JpaRepository<ProductItem, Long> {

    //ProductItemDTO getProductItemByProductId(Long id);
    ProductItem findProductItemByProductId(Long id);
    @Query("select p from ProductItem p where p.cart.id=:id")
    List<ProductItem> getProductItemByCartId(Long id);
}
