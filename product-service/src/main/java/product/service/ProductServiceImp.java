package product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import product.dto.RequestProductDTO;
import product.dto.ResponseProductDTO;
import product.entities.Product;
import product.mappers.ProductMapper;
import product.repository.ProductRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImp implements  ProductService{

    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    public ProductServiceImp(ProductRepo productRepo, ProductMapper productMapper) {
        this.productRepo = productRepo;
        this.productMapper = productMapper;
    }

    @Override
    public ResponseProductDTO saveProduct(RequestProductDTO requestProductDTO) {
        Product product = productMapper.requestProductDTOToProduct(requestProductDTO);
        Product saveProduct = productRepo.save(product);
        return productMapper.productToResponseProductDTO(saveProduct);
    }

    @Override
    public List<ResponseProductDTO> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products
                .stream()
                .map(productMapper::productToResponseProductDTO)
                .collect(Collectors.toList());
    }

    public List<Product> getAllProducts1() {
        return productRepo.findAll();
    }
    @Override
    public ResponseProductDTO getProduct(Long id) {
        Product product = productRepo.findById(id).get();
        return productMapper.productToResponseProductDTO(product);
    }

    @Override
    public ResponseProductDTO updateProduct(Long id, RequestProductDTO requestProductDTO) {
        Product product = productMapper.requestProductDTOToProduct(requestProductDTO);
        Product updateProduct = productRepo.save(product);
        return productMapper.productToResponseProductDTO(updateProduct);
    }
}
