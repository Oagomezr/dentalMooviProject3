package com.dentalmoovi.ventasproductos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentalmoovi.ventasproductos.models.Addresses;

public interface IAddressesRep extends JpaRepository<Addresses,Long>{
    
}
