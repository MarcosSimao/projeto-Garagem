package com.api.msuser.model.dto;

import com.api.msuser.model.entites.RoleModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto implements Serializable {
    private UUID userId;
    private String nome;
    private String cpf;
    private String password;
    private Set<RoleModel> roles=new HashSet<>();
}
