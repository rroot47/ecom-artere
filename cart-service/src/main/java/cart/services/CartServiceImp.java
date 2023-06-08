package cart.services;

import cart.dto.ProductItemDTO;
import cart.dto.ResponseCartDTO;
import cart.entities.Cart;
import cart.entities.ProductItem;
import cart.mappers.CartMapper;
import cart.mappers.ProductItemMapper;
import cart.model.Product;
import cart.repository.CartRepo;
import cart.repository.ProductItemRepo;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImp implements CartService {
    private final ProductRestClientService productRestClientService;
    private final CartRepo cartRepo;
    private final CartMapper cartMapper;
    private final ProductItemRepo productItemRepo;

    private final ProductItemMapper productItemMapper;
    private final ProductItemService productItemService;

    public CartServiceImp(ProductRestClientService productRestClientService, CartRepo cartRepo, CartMapper cartMapper, ProductItemRepo productItemRepo, ProductItemMapper productItemMapper, ProductItemService productItemService) {
        this.productRestClientService = productRestClientService;
        this.cartRepo = cartRepo;
        this.cartMapper = cartMapper;
        this.productItemRepo = productItemRepo;
        this.productItemMapper = productItemMapper;
        this.productItemService = productItemService;
    }


   /* public List<Product> getAll(){
        return productRestClientService.getAllProducts();
    }

    public Product getProduct(Long id){
        return productRestClientService.getProduct(id);
    }*/

    @Override
    public ResponseCartDTO createCart(){
        Cart cart = Cart.builder()
                .qte(0)
                .productItems(new ArrayList<>())
                .build();
        cartRepo.save(cart);
        return cartMapper.cartToResponseCartDTO(cart);
    }

    @Override
    public ResponseCartDTO getCart(Long idCart) {
        List<ProductItemDTO>  productItems = productItemService.getProductItemByCartId(idCart);
        ResponseCartDTO responseCartDTO = new ResponseCartDTO();
        responseCartDTO.setId(idCart);
        responseCartDTO.setQte(productItems.size());
        responseCartDTO.setProductItem(productItems);
        return responseCartDTO;
    }

    @Override
    public ResponseCartDTO addProductItemToCart(Long idCart,Long idProduct, int qte){
        Product product;
        ResponseCartDTO cartResponse;
        Cart cart = cartRepo.findById(idCart).get();
        ProductItem productItem = productItemRepo.findProductItemByProductId(idProduct);
        if(productItem==null){
            product = productRestClientService.getProduct(idProduct);
            productItem = ProductItem.builder()
                    .productId(product.getId())
                    .price(product.getPrice())
                    .quantity(qte)
                    .cart(cart)
                    .build();
        } else {
            productItem.setQuantity(productItem.getQuantity() + qte);
            productItem.setPrice(productItem.getPrice() * qte);
        }
        productItemRepo.save(productItem);
        cartResponse = getCart(idCart);
        return cartResponse;
    }
    public void deleteCart(Long idCart) {
        cartRepo.deleteById(idCart);
    }

    @Override
    public List<ResponseCartDTO> getAllCarts() {
        List<Cart> carts = cartRepo.findAll();
        List<ProductItem>  productItems = productItemRepo.findAll();
        List<ProductItemDTO> itemDTO = productItems.stream()
                .map(productItemMapper::productItemToProductItemDTO).toList();
        List<ResponseCartDTO> responseCartDTOS = carts.stream().map((cartMapper::cartToResponseCartDTO)).toList();
        responseCartDTOS.forEach(item ->item.setProductItem(itemDTO));
        return responseCartDTOS;
       // return carts.stream().map(cartMapper::cartToResponseCartDTO).collect(Collectors.toList());
    }
}
