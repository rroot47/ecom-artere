package cart.services;

import cart.dto.ResponseCartDTO;

import java.util.List;

public interface CartService {

    ResponseCartDTO createCart();
    ResponseCartDTO getCart(Long idCart);

    List<ResponseCartDTO> getAllCarts();
    void deleteCart(Long idCart);
    ResponseCartDTO addProductItemToCart(Long idCart,Long idProduct, int qte);
}
