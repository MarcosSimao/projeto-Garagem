package com.api.msuser.controller;

import com.api.msuser.model.dto.UserDto;
import com.api.msuser.model.entites.UserModel;
import com.api.msuser.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private  final UserService userService;
    @GetMapping("{cpf}")
    public ResponseEntity<UserDto>findBycpf(@PathVariable String cpf){
        log.info("analisando entrada {}",cpf);
        return ResponseEntity.ok().body(userService.findByCpf(cpf));
    }

}
