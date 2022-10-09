package com.api.msuser.controller;

import com.api.msuser.serviceTeste.UserService;
import com.api.msuser.utils.GenericoMapper;
import io.swagger.api.UsuarioApi;
import io.swagger.model.UserModelRepresetation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController implements UsuarioApi {
    private final UserService userService;
    @Override
    public ResponseEntity<UserModelRepresetation> userFindBycpf(String cpf) {
         log.info("analisando entrada {}",cpf);
        return ResponseEntity.ok().body(GenericoMapper.map(userService.findByCpf(cpf), UserModelRepresetation.class));
    }
}
