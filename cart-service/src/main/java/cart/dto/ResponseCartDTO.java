package cart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCartDTO {
    private Long id;
    private int qte;
    private List<ProductItemDTO> productItem;

}
