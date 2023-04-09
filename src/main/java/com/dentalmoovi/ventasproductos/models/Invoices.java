package com.dentalmoovi.ventasproductos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "invoices")
public class Invoices {
    
    @Id
    @GeneratedValue
    private Long idInvoice;

    private Integer quantity;

    private double amount;

    @ManyToOne
    private Orders idOrder;

    @ManyToOne
    private Products idProduct;
}
