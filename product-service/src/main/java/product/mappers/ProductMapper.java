package product.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import product.dto.RequestProductDTO;
import product.dto.ResponseProductDTO;
import product.entities.Product;

@Service
//@Mapper(componentModel = "spring")
public class ProductMapper  {
   // ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class );
    //ResponseProductDTO productToResponseProductDTO(Product product);
    //Product requestProductDTOToProduct(RequestProductDTO requestProductDTO);


    public ResponseProductDTO productToResponseProductDTO(Product product){
        ResponseProductDTO responseProductDTO = new ResponseProductDTO();
        BeanUtils.copyProperties(product, responseProductDTO);
        return  responseProductDTO;
    }

    public Product requestProductDTOToProduct(RequestProductDTO requestProductDTO){
        Product product = new Product();
        BeanUtils.copyProperties(requestProductDTO, product);
        return product;
    }
}
