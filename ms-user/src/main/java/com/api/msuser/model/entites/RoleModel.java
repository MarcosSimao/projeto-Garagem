package com.api.msuser.model.entites;

import com.api.msuser.model.enuns.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID roleId;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false,unique = false)
    private RoleName roleName;



}
