package com.dentalmoovi.ventasproductos.dtos;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RolesDTO {
    private Long idRole;
    private String nameRole;
    private Set<UsersDTO> users = new HashSet<>();
}
