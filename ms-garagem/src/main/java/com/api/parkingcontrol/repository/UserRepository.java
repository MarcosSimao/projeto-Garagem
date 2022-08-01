package com.api.parkingcontrol.repository;

import com.api.parkingcontrol.model.entites.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
    @Query("SELECT us FROM UserModel us JOIN FETCH us.roles WHERE us.userName=:username ")
    Optional<UserModel> findByUserName(@Param("username") String username);
}
