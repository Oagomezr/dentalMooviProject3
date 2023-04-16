package com.dentalmoovi.ventasproductos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoicesDTO {
    private Long idInvoice;
    private Integer quantity;
    private double amount;
    private OrdersDTO idOrder;
    private ProductsDTO idProduct;
}
