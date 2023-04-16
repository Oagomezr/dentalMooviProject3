package com.dentalmoovi.ventasproductos.dtos;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductsDTO {

    public ProductsDTO(String nameProduct, double unitPrice, String description, LocalDate expirationDate,
            String invima, String lote, Integer stock) {
        this.nameProduct = nameProduct;
        this.unitPrice = unitPrice;
        this.description = description;
        this.expirationDate = expirationDate;
        this.invima = invima;
        this.lote = lote;
        this.stock = stock;
    }
    
    private Long idProduct;
    private String nameProduct;
    private double unitPrice;
    private String description;
    private LocalDate expirationDate;
    private String invima;
    private String lote;
    private Integer stock;
}
