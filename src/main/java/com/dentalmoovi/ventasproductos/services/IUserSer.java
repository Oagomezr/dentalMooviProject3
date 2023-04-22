package com.dentalmoovi.ventasproductos.services;

import com.dentalmoovi.ventasproductos.dtos.UsersDTO;

public interface IUserSer {
    public UsersDTO createUser(UsersDTO userDTO) throws Exception;
    public UsersDTO getUser(Long idUser);
    public UsersDTO updateUser(Long id, UsersDTO userDTO) throws Exception;
    public void deleteUser(Long id);
}
