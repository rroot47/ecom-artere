package auth.client.dto;

import auth.role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInDTO {
    private Long id;
    private String token;
    private String username;
    private String email;
    private List<String> roles;

}
