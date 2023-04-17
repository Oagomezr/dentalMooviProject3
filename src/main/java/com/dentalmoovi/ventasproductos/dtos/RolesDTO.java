package com.dentalmoovi.ventasproductos.dtos;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RolesDTO {

    public RolesDTO(Long idRole, String nameRole) {
        this.idRole = idRole;
        this.nameRole = nameRole;
    }
    
    private Long idRole;
    private String nameRole;
    private Set<UsersDTO> users = new HashSet<>();
}
