package com.dentalmoovi.ventasproductos.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentMethodDTO {
    private Long idPaymentMethod;
    private String nameMethod;
}
