package com.dentalmoovi.ventasproductos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentalmoovi.ventasproductos.models.Products;

public interface IProductsRep extends JpaRepository<Products,Long>{
    
}
