package com.dentalmoovi.ventasproductos.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dentalmoovi.ventasproductos.dtos.UsersDTO;
import com.dentalmoovi.ventasproductos.exceptions.DataExistException;
import com.dentalmoovi.ventasproductos.exceptions.DataNotFoundException;
import com.dentalmoovi.ventasproductos.services.UserSer;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {
    
    @Autowired
    private UserSer userSer;

    @GetMapping
    public ResponseEntity<List<UsersDTO>> getAllUsers(){
        List <UsersDTO> users = userSer.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<UsersDTO> createUser(@RequestBody UsersDTO userDTO){
        try {
            UsersDTO userCreated = userSer.createUser(userDTO);
            return ResponseEntity.created(URI.create("/users/"+userCreated.getIdUser())).body(userCreated);
        } catch (DataExistException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersDTO> getUser(@PathVariable Long id){
        try {
            UsersDTO userGetted = userSer.getUser(id);
            return ResponseEntity.ok(userGetted);
        } catch (DataNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersDTO> actualizarUsuario(@PathVariable("id") Long id, @RequestBody UsersDTO usersDTO) {
        try {
            UsersDTO userUpdated = userSer.updateUser(id, usersDTO);
            return ResponseEntity.ok(userUpdated);
        } catch (DataNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        try {
            userSer.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (DataNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
