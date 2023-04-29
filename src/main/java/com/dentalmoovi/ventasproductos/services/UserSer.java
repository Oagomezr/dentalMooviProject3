package com.dentalmoovi.ventasproductos.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dentalmoovi.ventasproductos.dtos.AddressesDTO;
import com.dentalmoovi.ventasproductos.dtos.RolesDTO;
import com.dentalmoovi.ventasproductos.dtos.UsersDTO;
import com.dentalmoovi.ventasproductos.exceptions.DataExistException;
import com.dentalmoovi.ventasproductos.exceptions.DataNotFoundException;
import com.dentalmoovi.ventasproductos.models.Addresses;
import com.dentalmoovi.ventasproductos.models.Roles;
import com.dentalmoovi.ventasproductos.models.Users;
import com.dentalmoovi.ventasproductos.repositories.IRolesRep;
import com.dentalmoovi.ventasproductos.repositories.IUsersRep;

@Service
public class UserSer implements IUserSer{

    @Autowired
    private IUsersRep usersRep;
    @Autowired
    private IRolesRep rolesRep;

    @Override
    public List<UsersDTO> getAllUsers() {
        List<Users> users = usersRep.findAll();
        return users.stream().map(this::convertUserToDTO).collect(Collectors.toList());
    }

    @Override
    public UsersDTO createUser(UsersDTO userDTO){

        checkIfUserExist(userDTO);

        Users newUser = insertUserBasicDataFromDTO(userDTO); //add non foreign data
        
        newUser.setRoles(defaultRole()); //add default role --> USER

        Users userCreated = usersRep.save(newUser); // add complete user to the database

        userDTO.setIdUser(userCreated.getIdUser()); // get id generated from database and store inside DTO
        
        return userDTO;
    }

    @Override
    public UsersDTO getUser(Long idUser){
        Users user = usersRep.findById(idUser).orElseThrow(() -> new DataNotFoundException(notFoundMessage));
        return convertUserToDTO(user);
    }

    @Override
    public UsersDTO updateUser(Long id, UsersDTO userDTO){
        Users user = usersRep.findById(id).orElseThrow(() -> new DataNotFoundException(notFoundMessage));
        userDTO.setIdUser(id);
        user.setUsername(userDTO.getUsername());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setCelPhone(userDTO.getCelPhone());
        user.setBirthday(userDTO.getBirthday());
        user.setGender(userDTO.getGender());
        user = usersRep.save(user);
        return userDTO;
    }

    @Override
    public void deleteUser(Long id) {
        Users user = usersRep.findById(id).orElseThrow(() -> new DataNotFoundException(notFoundMessage));
        usersRep.delete(user);
    }

    private void checkIfUserExist(UsersDTO userDTO){
        // Check if username already exist
        Optional<Users> existingUser = usersRep.findByUsername(userDTO.getUsername());
        if (existingUser.isPresent()) {
            throw new DataExistException("El nombre de usuario ya está registrado");
        }

        // Check if email already exist
        existingUser = usersRep.findByEmail(userDTO.getEmail());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("El correo electrónico ya está registrado");
        }

        // Check if phone already exist
        existingUser = usersRep.findByCelPhone(userDTO.getCelPhone());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("El número de teléfono ya está registrado");
        }
    }

    private UsersDTO convertUserToDTO(Users user){
        UsersDTO userDTO = getUserFromDatabase(user);

        Set<Roles> roles = user.getRoles();
        if(roles !=null && !roles.isEmpty()){
            userDTO.setRoles(getRolesFromDatabase(roles));
        }

        Set<Addresses> addresses = user.getAddresses();
        if(addresses !=null && !addresses.isEmpty()){
            userDTO.setAddresses(getAdressesFromDatabase(addresses));
        }

        return userDTO;
    }

    private Set<RolesDTO> getRolesFromDatabase(Set<Roles> roles){
        Set<RolesDTO> rolesDTO = new HashSet<>();
        for(Roles role : roles){
            RolesDTO roleDTO = getRoleFromDatabase(role);
            rolesDTO.add(roleDTO);
        }
        return rolesDTO;
    }

    private RolesDTO getRoleFromDatabase(Roles role){
        return new RolesDTO(role.getIdRole(), role.getNameRole());
    }

    private Set<AddressesDTO> getAdressesFromDatabase(Set<Addresses> addresses){
        Set<AddressesDTO> addressesDTO = new HashSet<>();
        for(Addresses address : addresses){
            AddressesDTO addressDTO = getAddressFromDatabase(address);
            addressesDTO.add(addressDTO);
        }
        return addressesDTO;
    }

    private AddressesDTO getAddressFromDatabase(Addresses address){
        return new AddressesDTO(address.getIdAddress(), address.getCountry(), address.getDepartament(), address.getLocation(), address.getNeighborhood(), address.getAddress(), address.getPhoneContact());
    }

    private UsersDTO getUserFromDatabase(Users user){
        return new UsersDTO(user.getIdUser(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getCelPhone(), user.getBirthday(), user.getGender());
    }
    
    private Users insertUserBasicDataFromDTO(UsersDTO userDTO){
        return new Users(  
            userDTO.getUsername(), userDTO.getFirstName(), userDTO.getLastName(), 
            userDTO.getEmail(), userDTO.getCelPhone(), userDTO.getBirthday(), userDTO.getGender());
    }

    private Set<Roles> defaultRole(){
        Roles defaultRole = rolesRep.findByNameRole("USER");
        Set<Roles> userRoles = new HashSet<>();
        userRoles.add(defaultRole);
        return userRoles;
    }

    private String notFoundMessage = "user does not exists";
}

