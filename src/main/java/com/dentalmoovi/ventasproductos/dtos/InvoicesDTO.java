package com.dentalmoovi.ventasproductos.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InvoicesDTO {
    
    public InvoicesDTO(Integer quantity, double amount) {
        this.quantity = quantity;
        this.amount = amount;
    }

    private Long idInvoice;
    private Integer quantity;
    private double amount;
    private OrdersDTO idOrder;
    private ProductsDTO idProduct;
}
