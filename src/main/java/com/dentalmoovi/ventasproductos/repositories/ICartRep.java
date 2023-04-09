package com.dentalmoovi.ventasproductos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentalmoovi.ventasproductos.models.Cart;

public interface ICartRep extends JpaRepository<Cart, Long>{
    
}
