package com.dentalmoovi.ventasproductos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentalmoovi.ventasproductos.models.Users;

public interface IUsersRep extends JpaRepository<Users,Long>{
    
}
