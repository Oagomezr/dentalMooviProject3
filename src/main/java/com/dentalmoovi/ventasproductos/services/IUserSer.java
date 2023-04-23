package com.dentalmoovi.ventasproductos.services;

import java.util.Set;

import com.dentalmoovi.ventasproductos.dtos.UsersDTO;

public interface IUserSer {
    public Set<UsersDTO> getAllUsers();
    public UsersDTO createUser(UsersDTO userDTO);
    public UsersDTO getUser(Long idUser);
    public UsersDTO updateUser(Long id, UsersDTO userDTO);
    public void deleteUser(Long id);
}
