package com.beapsmarket.webapp.presentation.api;

import com.beapsmarket.webapp.model.dto.AddressDto;
import com.beapsmarket.webapp.model.dto.UserDto;
import com.beapsmarket.webapp.service.IAddress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/address")
@Slf4j
public class AddressRestController {
    @Autowired
    IAddress iAddress;

    @PostMapping(value = "/save")
    public void saveAddress(@RequestBody AddressDto addressDto) {
        AddressRestController.log.info("enregistrer-acte");
        iAddress.saveAddress(addressDto);
    }

    @GetMapping("/all")
    public ResponseEntity<Set<AddressDto>> getAllAddress(){
        return ResponseEntity.ok(iAddress.findAllAddress());
    }



    @GetMapping("/{code}/data")
    public ResponseEntity<AddressDto> getAddressByCode(@PathVariable int code) {
        return ResponseEntity.ok(iAddress.findAddressByCode(code));
    }

    @GetMapping("/{code}/delete")
    public  void deleteAddress(@PathVariable int code){
        iAddress.findAddressByCode(code);
    }

}
