package com.api.msuser.service;

import com.api.msuser.MsUserApplication;
import com.api.msuser.model.dto.RoleDto;
import com.api.msuser.model.entites.RoleModel;
import com.api.msuser.model.enuns.RoleName;
import com.api.msuser.repository.RoleRepository;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;


import java.util.UUID;


@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    public RoleModel save(RoleDto roleDto){
       return roleRepository.save(modelMapper.map(roleDto,RoleModel.class));
    }

    public static void main( String ... args){
        ApplicationContext applicationContext = new SpringApplicationBuilder(MsUserApplication.class)
                .web(WebApplicationType.NONE)
                        .run(args);

        RoleService servico = applicationContext.getBean(RoleService.class);
        servico.save(new RoleDto(UUID.randomUUID(),RoleName.ROLE_ADMIN));


    }
}
