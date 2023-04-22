package com.dentalmoovi.ventasproductos.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dentalmoovi.ventasproductos.dtos.AddressesDTO;
import com.dentalmoovi.ventasproductos.dtos.RolesDTO;
import com.dentalmoovi.ventasproductos.dtos.UsersDTO;
import com.dentalmoovi.ventasproductos.exceptions.DataNotFoundException;
import com.dentalmoovi.ventasproductos.models.Addresses;
import com.dentalmoovi.ventasproductos.models.Roles;
import com.dentalmoovi.ventasproductos.models.Users;
import com.dentalmoovi.ventasproductos.repositories.IAddressesRep;
import com.dentalmoovi.ventasproductos.repositories.IRolesRep;
import com.dentalmoovi.ventasproductos.repositories.IUsersRep;

@Service
public class UserSer implements IUserSer{

    @Autowired
    private IUsersRep usersRep;
    @Autowired
    private IRolesRep rolesRep;
    @Autowired
    private IAddressesRep addressesRep;

    @Override
    public UsersDTO createUser(UsersDTO userDTO) throws Exception {
        Users newUser = insertUserBasicDataFromDTO(userDTO); //add non foreign data
        
        newUser.setRoles(defaultRole()); //add default role --> USER

        Set<AddressesDTO> addressesDTO = userDTO.getAddresses();
        if(addressesDTO != null){
            newUser.setAddresses(createAddressesToDatabaseFromDTO(addressesDTO)); //add user addresses
        }

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
    public UsersDTO updateUser(Long id, UsersDTO userDTO) throws Exception {
        Users user = usersRep.findById(id).orElseThrow(() -> new DataNotFoundException(notFoundMessage));
        user.setUsername(userDTO.getUsername());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setCelPhone(userDTO.getCelPhone());
        user.setBirthday(userDTO.getBirthday());
        user.setGender(userDTO.getGender());
        return userDTO;
    }

    @Override
    public void deleteUser(Long id) {
        Users user = usersRep.findById(id).orElseThrow(() -> new DataNotFoundException(notFoundMessage));
        usersRep.delete(user);
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

    private Set<Addresses> createAddressesToDatabaseFromDTO(Set<AddressesDTO> addressesDTO){
        Set<Addresses> addresses = new HashSet<>();
        for(AddressesDTO addressDTO : addressesDTO){
            if(addressSearchFromDatabase(addressDTO) == null){ //if direction doesn't exist inside database
                Addresses newAddress = createAddressFromDTO(addressDTO);
                newAddress = addressesRep.save(newAddress); //save address in database
            }
            addresses.add(addressSearchFromDatabase(addressDTO)); //add address to collection
        }
        return addresses; //return all directions created
    }

    private Addresses createAddressFromDTO(AddressesDTO addressDTO){
        return new Addresses(  
            addressDTO.getCountry(), addressDTO.getDepartament(), addressDTO.getLocation(), 
            addressDTO.getNeighborhood(), addressDTO.getAddress(), addressDTO.getPhoneContact());
    }

    private Addresses addressSearchFromDatabase(AddressesDTO addressDTO){
        return addressesRep.findByAddressAndLocation(  
            addressDTO.getAddress(),addressDTO.getLocation());
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

