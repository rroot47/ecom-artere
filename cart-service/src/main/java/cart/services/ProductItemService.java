package cart.services;

import cart.dto.ProductItemDTO;
import cart.entities.Cart;
import cart.entities.ProductItem;

import java.util.List;

public interface ProductItemService {

    ProductItemDTO getProductItem(Long id);

    List<ProductItemDTO> getProductItemByCartId(Long id);
    void deleteProductItem(Long id);
}
