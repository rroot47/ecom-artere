package cart.services;

import cart.dto.ProductItemDTO;
import cart.entities.Cart;
import cart.entities.ProductItem;
import cart.mappers.ProductItemMapper;
import cart.repository.ProductItemRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductItemServiceImp implements ProductItemService{


    private final ProductItemRepo productItemRepo;
    private final ProductItemMapper productItemMapper;

    public ProductItemServiceImp(ProductItemRepo productItemRepo, ProductItemMapper productItemMapper) {
        this.productItemRepo = productItemRepo;
        this.productItemMapper = productItemMapper;
    }

    @Override
    public ProductItemDTO getProductItem(Long id) {
        ProductItem productItem = productItemRepo.findProductItemByProductId(id);
        return productItemMapper.productItemToProductItemDTO(productItem);
    }

    @Override
    public List<ProductItemDTO> getProductItemByCartId(Long id) {
        List<ProductItem> productItem=  productItemRepo.getProductItemByCartId(id);
        return productItem.stream().map(productItemMapper::productItemToProductItemDTO).toList();
    }

    @Override
    public void deleteProductItem(Long id) {

    }
}
