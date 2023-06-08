package auth.client;

import auth.client.dto.RequestClientDTO;
import auth.client.dto.RequestLoginDTO;
import auth.client.dto.ResponseClientDTO;
import auth.client.dto.SignInDTO;
import auth.security.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api")
public class ClientController {

    public final ClientService clientService;
    private final AuthService authService;


    @PostMapping("/client")
    public ResponseClientDTO addClient(@RequestBody RequestClientDTO requestClientDTO){
        return clientService.saveClient(requestClientDTO);
    }

    @GetMapping("/client/{idClient}")
    public ResponseClientDTO getClient(@PathVariable("idClient") Long idClient) throws ChangeSetPersister.NotFoundException {
        return clientService.getClient(idClient);
    }

    @PostMapping("/client/login")
    public SignInDTO login(@RequestBody RequestLoginDTO requestLoginDTO){
        return authService.signIn(requestLoginDTO);
    }
}
