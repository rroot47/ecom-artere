package cart.services;

import cart.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service")
public interface ProductRestClientService {
    @GetMapping("/api/products")
    List<Product> getAllProducts();
    @GetMapping("/api/product/{id}")
    Product getProduct(@PathVariable("id") Long id);
}
