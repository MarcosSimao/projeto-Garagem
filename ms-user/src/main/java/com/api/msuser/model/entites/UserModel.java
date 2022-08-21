package com.api.msuser.model.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "tb_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false,unique = true)
    private String cpf;
    @Column(nullable = false)
    private String password;
    @ManyToMany
    @JoinTable(name = "tb_user_Role",
    joinColumns = @JoinColumn(name = "userId"),
    inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<RoleModel>roles=new HashSet<>();





}


