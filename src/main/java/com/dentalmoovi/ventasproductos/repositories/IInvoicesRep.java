package com.dentalmoovi.ventasproductos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentalmoovi.ventasproductos.models.Invoices;

public interface IInvoicesRep extends JpaRepository<Invoices,Long>{
    
}
