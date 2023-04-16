package com.dentalmoovi.ventasproductos.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentMethodDTO {

    public PaymentMethodDTO(String nameMethod) {
        this.nameMethod = nameMethod;
    }
    
    private Long idPaymentMethod;
    private String nameMethod;
}
