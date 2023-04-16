package com.dentalmoovi.ventasproductos.dtos;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RolesDTO {
    private Long idRole;
    private String nameRole;
    private Set<UsersDTO> users = new HashSet<>();
}
