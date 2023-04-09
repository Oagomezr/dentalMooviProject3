package com.dentalmoovi.ventasproductos.dtos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class UsersDTO {
    private Long idUser;
    private String firstName;
    private String lastName;
    private String email;
    private String celPhone;
    private LocalDate birthday;
    private String gender;
    private String password;
    private Set<RolesDTO> roles = new HashSet<>();
    private Set<AddressesDTO> addresses = new HashSet<>();
}
