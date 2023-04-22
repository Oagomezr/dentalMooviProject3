package com.dentalmoovi.ventasproductos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.dentalmoovi.ventasproductos.models.Users;

public interface IUsersRep extends JpaRepository<Users,Long>{
    public Users findByUsername(@Param("username") String username);
    public Users findByEmail(@Param("email") String email);
    public Users findByCelPhone(@Param("celPhone") String celPhone);
}
