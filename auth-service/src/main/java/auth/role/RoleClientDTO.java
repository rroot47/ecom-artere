package auth.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleClientDTO {

    private Long client_id;
    private Long role_id;
    private List<Role> role;
}
