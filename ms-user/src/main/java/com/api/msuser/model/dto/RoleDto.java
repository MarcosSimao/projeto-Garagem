package com.api.msuser.model.dto;

import com.api.msuser.model.enuns.RoleName;
import lombok.Data;

import java.io.Serializable;
@Data
public class RoleDto implements Serializable {
    private RoleName roleName;
}
