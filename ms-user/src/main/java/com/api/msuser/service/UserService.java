package com.api.msuser.service;

import com.api.msuser.model.entites.RoleModel;
import com.api.msuser.model.entites.UserModel;
import com.api.msuser.model.enuns.RoleName;
import com.api.msuser.model.exceptions.ObjectNotFoundException;
import com.api.msuser.repository.RoleRepository;
import com.api.msuser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;


import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository repository;
    private final RoleRepository repositoryRole;
    private final ModelMapper modelMapper;

    public void addRoleToUser(String cpf, RoleName roleName) {
        UserModel user = repository.findByCpf(cpf).get();
        RoleModel role = repositoryRole.findByRoleName(roleName);
        user.getRoles().add(role);
    }

    public UserModel findByCpf(String cpf) {
        log.info("entrada de cpf {}", cpf);
        var userModel = Optional.ofNullable(repository.findByCpf(cpf)
                .orElseThrow(() -> new ObjectNotFoundException("cpf " + cpf + " nao encontrado")));
        log.info("checando se usuario esta cadastrado {} ", userModel);
        return userModel.get();
    }

}
