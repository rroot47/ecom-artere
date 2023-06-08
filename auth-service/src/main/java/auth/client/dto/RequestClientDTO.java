package auth.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestClientDTO {
    private String nom;
    private String prenom;
    private String email;
    private String password;
}
