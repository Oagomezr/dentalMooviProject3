package com.dentalmoovi.ventasproductos.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrdersDTO {
    private Long idOrder;
    private double total;
    private LocalDate orderDate;
    private UsersDTO idUser;
    private PaymentMethodDTO idPaymentMethod;
    private AddressesDTO idAddress;
}
