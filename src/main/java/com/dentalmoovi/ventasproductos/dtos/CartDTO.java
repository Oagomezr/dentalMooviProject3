package com.dentalmoovi.ventasproductos.dtos;

import lombok.Data;

@Data
public class CartDTO {
    private Long idCart;
    private Integer quantity;
    private UsersDTO idUser;
    private ProductsDTO idProduct;
}
