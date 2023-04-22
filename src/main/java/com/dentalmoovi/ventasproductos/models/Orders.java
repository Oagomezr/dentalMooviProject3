package com.dentalmoovi.ventasproductos.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    private LocalDate orderDate;

    @ManyToOne
    private Users idUser;

    @ManyToOne
    private PaymentMethod idPaymentMethod;
    
    @ManyToOne
    private Addresses idAddress;
}
