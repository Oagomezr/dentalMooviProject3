package com.dentalmoovi.ventasproductos.services;

import java.util.List;

import com.dentalmoovi.ventasproductos.dtos.UsersDTO;

public interface IUserSer {
    public List<UsersDTO> getAllUsers();
    public UsersDTO createUser(UsersDTO userDTO);
    public UsersDTO getUser(Long idUser);
    public boolean checkValueExists(String field ,String value);
    public UsersDTO updateUser(Long id, UsersDTO userDTO);
    public void deleteUser(Long id);
}
