package com.beapsmarket.webapp.presentation.api;


import com.beapsmarket.webapp.model.dto.AddressDto;
import com.beapsmarket.webapp.model.dto.ShoppingListDto;
import com.beapsmarket.webapp.service.IShoppingList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/shoppingList")
@Slf4j
public class ShoppingListRestController {
    @Autowired
    IShoppingList iShoppingList;

    @PostMapping(value = "/save")
    public void saveAddress(@RequestBody ShoppingListDto shoppingListDto) {
        ShoppingListRestController.log.info("enregistrer-shoppingList");
        iShoppingList.saveShoppingList(shoppingListDto);
    }
    @GetMapping("/{code}/delete")
    public  void deleteShoppingList(@PathVariable String code){
        iShoppingList.deleteShoppingList(code);
    }

    @GetMapping("/all")
    public ResponseEntity<Set<ShoppingListDto>> getAllShoppingList(){
        return ResponseEntity.ok(iShoppingList.ListShoppingList());
    }


    @GetMapping("/{code}/data")
    public ResponseEntity<ShoppingListDto> getAddressByCode(@PathVariable String code) {
        return ResponseEntity.ok(iShoppingList.searchShoppingListByReference(code));
    }



}
