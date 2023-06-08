package auth.security;

import auth.client.Client;
import auth.client.ClientRepo;
import auth.client.dto.RequestLoginDTO;
import auth.client.dto.SignInDTO;
import auth.role.Role;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class AuthService {

    private final JwtEncoder jwtEncoder;
    private final AuthenticationManager authenticationManager;
    private final ClientRepo clientRepo;

    public SignInDTO signIn(RequestLoginDTO requestLoginDTO){

        String subject;
        SignInDTO signInDTO = new SignInDTO();
        List<String> roles;
        Instant instant=Instant.now();

        Optional<Client> client = clientRepo.findClientByEmail(requestLoginDTO.getEmail());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestLoginDTO.getEmail(), requestLoginDTO.getPassword())
        );
        subject=authentication.getName();
        roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        JwtClaimsSet jwtClaimsSet=JwtClaimsSet.builder()
                .subject(subject)
                .issuedAt(instant)
                .expiresAt(instant.plus(3, ChronoUnit.HOURS))
                .issuer("auth-service")
                .claim("roles",roles)
                .build();
        String jwtAccessToken=jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
        signInDTO.setToken(jwtAccessToken);
        signInDTO.setId(client.get().getId());
        signInDTO.setUsername(client.get().getPrenom());
        signInDTO.setEmail(client.get().getEmail());
        signInDTO.setRoles(roles);
        return signInDTO;
    }
}
