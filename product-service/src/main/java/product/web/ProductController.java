package product.web;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import product.dto.RequestProductDTO;
import product.dto.ResponseProductDTO;
import product.entities.Product;
import product.service.ProductService;

import java.util.List;


@RestController
//@RefreshScope
@RequestMapping("api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/products")
    public List<ResponseProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/prods")
    public List<Product> getAllProducts1(){
        return productService.getAllProducts1();
    }

    @GetMapping("/product/{id}")
    ResponseProductDTO getProduct(@PathVariable("id") Long id){
        return productService.getProduct(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/product")
    public ResponseProductDTO addProduct(@RequestBody RequestProductDTO requestProductDTO) {
        return productService.saveProduct(requestProductDTO);
    }

    @PatchMapping ("/product/{id}")
    public ResponseProductDTO updateProduct(@PathVariable("id") Long id, @RequestBody RequestProductDTO requestProductDTO) {
        return productService.updateProduct(id, requestProductDTO);
    }
}
