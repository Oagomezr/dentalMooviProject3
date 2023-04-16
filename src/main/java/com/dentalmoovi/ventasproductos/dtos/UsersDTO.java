package com.dentalmoovi.ventasproductos.dtos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsersDTO {
    private Long idUser;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String celPhone;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate birthday;
    private String gender;
    private String password;
    private Set<RolesDTO> roles = new HashSet<>();
    private Set<AddressesDTO> addresses = new HashSet<>();
}
