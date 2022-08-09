package com.api.msuser.repository;

import com.api.msuser.model.entites.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface RoleRepository extends JpaRepository<RoleModel, UUID> {
}
