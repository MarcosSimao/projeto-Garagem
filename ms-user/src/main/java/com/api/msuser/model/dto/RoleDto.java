package com.api.msuser.model.dto;

import com.api.msuser.model.enuns.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
public class RoleDto implements Serializable {
    private UUID roleId;
    private RoleName roleName;
}
