package auth.client;

import auth.client.dto.RequestClientDTO;
import auth.client.dto.ResponseClientDTO;
import auth.role.Role;
import auth.role.RoleRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
@AllArgsConstructor
public class ClientService {

    private final ClientRepo  clientRepo;
    private final ClientMapper clientMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepo roleRepo;

    public Optional<Client> findClientByEmail(String email){
        return clientRepo.findClientByEmail(email);
    }
    public ResponseClientDTO saveClient(RequestClientDTO requestClientDTO){
        Client client = clientMapper.INSTANCE.requestClientDTOToClient(requestClientDTO);
        client.setRoles(roleRepo.findRoleByRoleName("USER"));
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        Client clientSave = clientRepo.save(client);
        return clientMapper.clientToResponseClientDTO(clientSave);
    }
    public ResponseClientDTO getClient(Long client_id) throws ChangeSetPersister.NotFoundException {
        Client client = clientRepo.findById(client_id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
        return clientMapper.clientToResponseClientDTO(client);
    }
}
