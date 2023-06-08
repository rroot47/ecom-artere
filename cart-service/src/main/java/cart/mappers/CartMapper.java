package cart.mappers;

import cart.dto.RequestCartDTO;
import cart.dto.ResponseCartDTO;
import cart.entities.Cart;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CartMapper {
    public ResponseCartDTO cartToResponseCartDTO(Cart cart){
        ResponseCartDTO responseCartDTO = new ResponseCartDTO();
        BeanUtils.copyProperties(cart, responseCartDTO);
        return  responseCartDTO;
    }

    public Cart requestCartDTOToCart(RequestCartDTO requestCartDTO){
        Cart cart = new Cart();
        BeanUtils.copyProperties(requestCartDTO, cart);
        return cart;
    }
}
