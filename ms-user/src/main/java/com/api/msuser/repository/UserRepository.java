package com.api.msuser.repository;

import com.api.msuser.model.entites.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
    @Query("select u from UserModel u JOIN FETCH u.roles WHERE u.cpf=:cpf")
    Optional<UserModel>findByCpf(@Param("cpf") String cpf);

}
