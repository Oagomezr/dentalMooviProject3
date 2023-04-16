package com.dentalmoovi.ventasproductos.dtos;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductsDTO {
    private Long idProduct;
    private String nameProduct;
    private double unitPrice;
    private String description;
    private LocalDate expirationDate;
    private String invima;
    private String lote;
    private Integer stock;
}
