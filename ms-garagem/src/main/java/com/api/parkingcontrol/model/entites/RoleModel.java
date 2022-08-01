package com.api.parkingcontrol.model.entites;

import com.api.parkingcontrol.model.enuns.RoleName;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_role")
@Data
public class RoleModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID roleId;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false,unique = false)
    private RoleName roleName;


}
