package com.dentalmoovi.ventasproductos.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartDTO {
    private Long idCart;
    private Integer quantity;
    private UsersDTO idUser;
    private ProductsDTO idProduct;
}
