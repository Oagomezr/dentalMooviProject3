package com.dentalmoovi.ventasproductos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.dentalmoovi.ventasproductos.models.Addresses;

public interface IAddressesRep extends JpaRepository<Addresses,Long>{
    Addresses findByAddressAndLocation(@Param("address") String address, @Param("location") String location);
}
