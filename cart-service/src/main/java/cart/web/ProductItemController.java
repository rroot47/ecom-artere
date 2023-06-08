package cart.web;


import cart.dto.ProductItemDTO;
import cart.services.ProductItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class ProductItemController {

    private final ProductItemService productItemService;

    public ProductItemController(ProductItemService productItemService) {
        this.productItemService = productItemService;
    }

    @GetMapping("/productitems/{id}")
    public List<ProductItemDTO> getProductItemByCartId(@PathVariable Long id) {
        return productItemService.getProductItemByCartId(id);
    }
    @GetMapping("/product-item/{id}")
    public ProductItemDTO getProductItem(@PathVariable Long id) {
        return productItemService.getProductItem(id);
    }
}
