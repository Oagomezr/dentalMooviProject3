package com.dentalmoovi.ventasproductos.dtos;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrdersDTO {
    
    public OrdersDTO(double total, LocalDate orderDate) {
        this.total = total;
        this.orderDate = orderDate;
    }
    
    private Long idOrder;
    private double total;
    private LocalDate orderDate;
    private UsersDTO idUser;
    private PaymentMethodDTO idPaymentMethod;
    private AddressesDTO idAddress;
}
