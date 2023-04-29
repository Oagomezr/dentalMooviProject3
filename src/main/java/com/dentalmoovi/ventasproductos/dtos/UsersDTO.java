package com.dentalmoovi.ventasproductos.dtos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsersDTO {

    public UsersDTO(Long idUser, String username, String firstName, String lastName, String email, String celPhone,
            LocalDate birthday, String gender) {
        this.idUser = idUser;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.celPhone = celPhone;
        this.birthday = birthday;
        this.gender = gender;
    }

    private Long idUser;
    private String username;
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
