package auth.client.dto;

import auth.role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseClientDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private Set<Role> roles;
}
