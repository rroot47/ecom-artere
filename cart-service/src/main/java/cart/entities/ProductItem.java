package cart.entities;

import cart.model.Product;
//import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  Long productId;
    @Transient
    private Product product;
    private double price;
    private int quantity;//dans le cart
    @ManyToOne
   // @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Cart cart;
}