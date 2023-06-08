package auth.client;

import auth.client.dto.RequestClientDTO;
import auth.client.dto.ResponseClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
@Service
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
    ResponseClientDTO clientToResponseClientDTO(Client client);
    Client requestClientDTOToClient(RequestClientDTO requestClientDTO);
}
