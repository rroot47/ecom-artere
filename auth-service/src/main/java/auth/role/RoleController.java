package auth.role;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api")
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/role")
    public ResponseRoleDTO addRole(@RequestBody RoleDTO roleName){
        return roleService.saveRole(roleName);
    }

    @PostMapping("/role/addRoleToClient")
    public RoleClientDTO addRoleToClient(@RequestBody RequestRoleClientDTO requestRoleClientDTO) {
        return roleService.addRoleToClient(requestRoleClientDTO);
    }
}
