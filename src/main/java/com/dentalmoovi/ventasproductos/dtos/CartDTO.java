package com.dentalmoovi.ventasproductos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartDTO {
    private Long idCart;
    private Integer quantity;
    private UsersDTO idUser;
    private ProductsDTO idProduct;
}
