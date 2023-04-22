package com.dentalmoovi.ventasproductos.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table
public class Addresses {

    public Addresses(String country, String departament, String location, String neighborhood, String address,
            String phoneContact) {
        this.country = country;
        this.departament = departament;
        this.location = location;
        this.neighborhood = neighborhood;
        this.address = address;
        this.phoneContact = phoneContact;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAddress;

    @Column(nullable = false, length = 20)
    private String country;
    @Column(nullable = false, length = 20)
    private String departament;
    @Column(nullable = false, length = 20)
    private String location;
    @Column(nullable = true, length = 20)
    private String neighborhood;
    @Column(nullable = false, length = 30)
    private String address;
    @Column(nullable = false, length = 15)
    private String phoneContact;

    @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Users> users = new HashSet<>();
}
