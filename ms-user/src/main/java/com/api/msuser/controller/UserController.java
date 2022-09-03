package com.api.msuser.controller;
import com.api.msuser.service.UserService;
import io.tej.SwaggerCodgen.api.UsuarioApi;
import io.tej.SwaggerCodgen.model.UserModelRepresetation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController implements UsuarioApi {
    private final UserService userService;
    private final ModelMapper modelMapper;
    public ResponseEntity<UserModelRepresetation> userFindBycpf(String cpf){
        log.info("analisando entrada {}",cpf);
        return ResponseEntity.ok().body(modelMapper.map(userService.findByCpf(cpf), UserModelRepresetation.class));
    }

}
