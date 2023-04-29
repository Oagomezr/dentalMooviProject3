package com.dentalmoovi.ventasproductos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.dentalmoovi.ventasproductos.models.Users;

public interface IUsersRep extends JpaRepository<Users,Long>{
    public Optional<Users> findByUsername(@Param("username") String username);
    public Optional<Users> findByEmail(@Param("email") String email);
    public Optional<Users> findByCelPhone(@Param("celPhone") String celPhone);
}
