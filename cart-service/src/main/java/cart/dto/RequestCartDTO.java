package cart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestCartDTO {
    private int qte;
    private Collection<ProductDTO> productItems;
}
