package cart.web;

import cart.dto.ResponseCartDTO;

import cart.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final KafkaTemplate<String, ResponseCartDTO> kafkaTemplate;

    @PostMapping("/cart")
    public ResponseCartDTO createCart(){
        return cartService.createCart();
    }
    @PostMapping("/cart/{id}/{idProduct}")
    public ResponseCartDTO addProductToCart(@PathVariable Long id, @PathVariable("idProduct") Long idProduct, @RequestParam int qte){
        ResponseCartDTO cartResponse = cartService.addProductItemToCart(id,idProduct, qte);
        kafkaTemplate.send("R1", String.valueOf(id), cartResponse);
        return cartResponse;
    }

    @GetMapping("/carts")
    public List<ResponseCartDTO> getAllCarts() {
        return cartService.getAllCarts();
    }

    @GetMapping("/cart/{idCart}")
    public ResponseCartDTO getCart(@PathVariable("idCart") Long idCart){
        return cartService.getCart(idCart);
    }

    @DeleteMapping("/cart/{idCart}")
    public void deleteCart(@PathVariable("idCart") Long idCart) {
        cartService.deleteCart(idCart);
    }
    /*@GetMapping("/cart")
    public List<ProductDTO> getAll(){
        return cartServiceImp.getAll();
    }

    @GetMapping("/cart/{id}")
    ProductDTO getProduct(@PathVariable("id") Long id){
        return cartServiceImp.getProduct(id);
    }*/
}
