package com.dentalmoovi.ventasproductos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private Long idCart;
    private Integer quantity;
    private UsersDTO idUser;
    private ProductsDTO idProduct;
}
