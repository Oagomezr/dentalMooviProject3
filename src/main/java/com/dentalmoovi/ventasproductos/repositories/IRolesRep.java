package com.dentalmoovi.ventasproductos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.dentalmoovi.ventasproductos.models.Roles;

public interface IRolesRep extends JpaRepository<Roles,Long>{
    public Roles findByNameRole(@Param("nameRole") String nameRole);
}
