package auth.role;

import auth.client.Client;
import auth.client.ClientRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class RoleService {
    private final ClientRepo clientRepo;
    private final RoleRepo roleRepo;

    private final RoleMapper roleMapper;

    public RoleClientDTO addRoleToClient(RequestRoleClientDTO requestRoleClientDTO) {
        RoleClientDTO roleClientDTO = new RoleClientDTO();
        List<Role> roleList = new ArrayList<>();
        Optional<Client> client = clientRepo.findClientByEmail(requestRoleClientDTO.getEmail());
        Role role = roleRepo.getRole(requestRoleClientDTO.getRoleName());
        Client client1 = clientRepo.findById(client.get().getId()).get();
        client1.getRoles().add(role);
        clientRepo.save(client1);
        roleList.add(role);
        roleClientDTO.setClient_id(client1.getId());
        roleClientDTO.setRole_id(role.getId());
        roleClientDTO.setRole(roleList);
        return roleClientDTO;
    }

    public ResponseRoleDTO saveRole(RoleDTO roleDTO){
        Role role  = roleMapper.INSTANCE.roleDTOToRole(roleDTO);
        Role saveRole=  roleRepo.save(role);
        return  roleMapper.roleToResponseRoleDTO(saveRole);
    }

}
