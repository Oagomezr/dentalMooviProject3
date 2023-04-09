package com.dentalmoovi.ventasproductos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentalmoovi.ventasproductos.models.PaymentMethod;

public interface IPaymentMethodRep extends JpaRepository<PaymentMethod,Long>{
    
}
