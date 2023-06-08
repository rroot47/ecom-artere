package cart.mappers;

import cart.dto.ProductItemDTO;
import cart.dto.RequestCartDTO;
import cart.dto.ResponseCartDTO;
import cart.entities.Cart;
import cart.entities.ProductItem;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductItemMapper {

    public ProductItemDTO productItemToProductItemDTO(ProductItem productItem){
        ProductItemDTO productItemDTO = new ProductItemDTO();
        BeanUtils.copyProperties(productItem, productItemDTO);
        return  productItemDTO;
    }

    public List<ProductItemDTO> productItemToProductItemDTOList(List<ProductItem> productItem){
        List<ProductItemDTO> productItemDTO = new ArrayList<>();
        BeanUtils.copyProperties(productItem, productItemDTO);
        return  productItemDTO;
    }

    public ProductItem productItemDTOToProductItem(ProductItemDTO productItemDTO){
        ProductItem productItem = new ProductItem();
        BeanUtils.copyProperties(productItemDTO, productItem);
        return productItem;
    }
}
