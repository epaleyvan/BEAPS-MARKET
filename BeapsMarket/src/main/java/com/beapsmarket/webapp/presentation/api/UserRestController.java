package com.beapsmarket.webapp.presentation.api;

import com.beapsmarket.webapp.model.dto.AddressDto;
import com.beapsmarket.webapp.model.dto.UserDto;
import com.beapsmarket.webapp.service.IUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserRestController {

    @Autowired
    private IUser iUser;

    @PostMapping(value = "/save")
    public void saveUser(@RequestBody UserDto userDto) {
        UserRestController.log.info("enregistrer-acte");
        iUser.saveUser(userDto);
    }

    @GetMapping("/all")
    public ResponseEntity<Set<UserDto>> getAllUsers(){
        return ResponseEntity.ok(iUser.findAllUser());
    }


    @GetMapping("/username/{username}/data")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(iUser.findUserByUsername(username));
    }

    @GetMapping("/username/{username}/address")
    public ResponseEntity<Set<AddressDto>> getUserAddress(@PathVariable String username) {
        return ResponseEntity.ok(iUser.findUserByUsername(username).getAddressesDtos());
    }

    @GetMapping("/email/{email}/data")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(iUser.findUserByEmail(email));
    }


    @GetMapping("/{email}/delete")
    public void deleteUserByEmail(@PathVariable String email){
        iUser.deleteUserByEmail(email);
    }

}
