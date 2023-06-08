package auth.role;

import auth.client.Client;
import auth.client.ClientMapper;
import auth.client.dto.RequestClientDTO;
import auth.client.dto.ResponseClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
@Service
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
    ResponseRoleDTO roleToResponseRoleDTO(Role role);
    Role roleDTOToRole(RoleDTO roleDTO);
}
