package com.beapsmarket.webapp.presentation.controller;


import com.beapsmarket.webapp.model.dto.ShoppingListDto;
import com.beapsmarket.webapp.service.IShoppingList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
@Slf4j
public class ShoppingListcontroller {
    @Autowired
    IShoppingList iShoppingList;

    /*@GetMapping("/listshoppingLists")
    public String chartpage(Model model){
        Set<ShoppingListDto> shoppingListDtos =iShoppingList.istShoppingList();
        model.addAttribute("shoppinglistDtos",shoppingListDtos);
        return "chart";
    }
    //revoir cette methode
    @PostMapping("/shoppingList/enregistrer")
    public String validershoppingList(@ModelAttribute ShoppingListDto shoppingListDto,Model model){
        ShoppingListcontroller.log.info("ShoppingList-valider");
        iShoppingList.saveShoppingList(shoppingListDto);
        return "chart";
    }

    //revoir la page retournee dans cette methode , comment afficher les
    //resultats de la recherche sans creer une autre page pour l'afficher
    @PostMapping("/shoppingList/rechercher")
    public String recherchershoppinglist(@RequestParam(value = "keyword")String keyword, Model model){

        try{
            //faire en sorte que cela genere une exception
            ShoppingListDto shoppingListDto = iShoppingList.searchShoppingListByReference(keyword);
            model.addAttribute("shoppingListDto",shoppingListDto);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return "chart";


        //Ecrire la methode update
    }*/



}
