package product.service;

import product.dto.RequestProductDTO;
import product.dto.ResponseProductDTO;
import product.entities.Product;

import java.util.List;

public interface ProductService {
    ResponseProductDTO saveProduct(RequestProductDTO requestProductDTO);
    List<ResponseProductDTO> getAllProducts();
    List<Product> getAllProducts1();
    ResponseProductDTO getProduct(Long id);
    ResponseProductDTO updateProduct(Long id, RequestProductDTO requestProductDTO);
}
