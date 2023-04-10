package com.dentalmoovi.ventasproductos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentalmoovi.ventasproductos.models.Roles;

public interface IRolesRep extends JpaRepository<Roles,Long>{
    public Roles findByNameRole(String nameRole);
}
