package com.dentalmoovi.ventasproductos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethodDTO {
    private Long idPaymentMethod;
    private String nameMethod;
}
