package com.dentalmoovi.ventasproductos.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
public class Users {

    public Users(String firstName, String lastName, String email, String celPhone, LocalDate birthday, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.celPhone = celPhone;
        this.birthday = birthday;
        this.gender = gender;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(nullable = false, length = 25)
    private String firstName;

    @Column(nullable = false, length = 25)
    private String lastName;

    @Column(nullable = false, unique = true, length = 60)
    private String email;

    @Column(nullable = false, unique = true, length = 10)
    private String celPhone;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(nullable = true)
    private LocalDate birthday;

    @Column(nullable = false, length = 15)
    private String gender;

    @Column(nullable = true)
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "users_roles",
                joinColumns = { @JoinColumn(name = "id_user") },
                inverseJoinColumns = { @JoinColumn(name = "id_role") })
    private Set<Roles> roles = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "users_addresses",
                joinColumns = { @JoinColumn(name = "id_user") },
                inverseJoinColumns = { @JoinColumn(name = "id_address") })
    private Set<Addresses> addresses = new HashSet<>();
}
