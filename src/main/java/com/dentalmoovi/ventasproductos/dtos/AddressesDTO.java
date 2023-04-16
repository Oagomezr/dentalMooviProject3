package com.dentalmoovi.ventasproductos.dtos;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressesDTO {

    public AddressesDTO(String country, String departament, String location, String neighborhood, String address,
            String phoneContact) {
        this.country = country;
        this.departament = departament;
        this.location = location;
        this.neighborhood = neighborhood;
        this.address = address;
        this.phoneContact = phoneContact;
    }

    private Long idAddress;
    private String country;
    private String departament;
    private String location;
    private String neighborhood;
    private String address;
    private String phoneContact;
    private Set<UsersDTO> users = new HashSet<>();
}
