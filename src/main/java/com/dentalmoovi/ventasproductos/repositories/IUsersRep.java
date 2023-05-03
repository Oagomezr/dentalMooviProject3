package com.dentalmoovi.ventasproductos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.dentalmoovi.ventasproductos.models.Users;

public interface IUsersRep extends JpaRepository<Users,Long>{
    boolean existsByUsername(@Param("username") String username);
    boolean existsByEmail(@Param("email") String email);
    boolean existsByCelPhone(@Param("celPhone") String phone);
}
