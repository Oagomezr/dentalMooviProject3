package com.dentalmoovi.ventasproductos.dtos;

import lombok.Data;

@Data
public class InvoicesDTO {
    private Long idInvoice;
    private Integer quantity;
    private double amount;
    private OrdersDTO idOrder;
    private ProductsDTO idProduct;
}
