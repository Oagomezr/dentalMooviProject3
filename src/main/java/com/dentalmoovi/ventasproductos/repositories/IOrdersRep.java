package com.dentalmoovi.ventasproductos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentalmoovi.ventasproductos.models.Orders;

public interface IOrdersRep extends JpaRepository<Orders, Long>{
    
}
