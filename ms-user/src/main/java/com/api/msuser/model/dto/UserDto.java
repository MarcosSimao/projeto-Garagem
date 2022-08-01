package com.api.msuser.model.dto;

import com.api.msuser.model.entites.RoleModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto implements Serializable {
    private String nome;
    private String cpf;
    private String password;
    private Set<RoleModel> roles=new HashSet<>();;
}
