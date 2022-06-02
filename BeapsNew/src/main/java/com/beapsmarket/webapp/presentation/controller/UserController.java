package com.beapsmarket.webapp.presentation.controller;


import com.beapsmarket.webapp.model.dto.ShoppingListDto;
import com.beapsmarket.webapp.service.IUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;


@Controller
@Slf4j
public class UserController {
    @Autowired
    IUser iUser;


    @GetMapping("/login")
    public String loginForm(Model model){
        return "login";
    }


    @GetMapping("/chart")
    public String showAllShoppingList(@RequestParam(name = "username") String username, Model model){
        Set<ShoppingListDto> shoppingListDtos = iUser.findUserByUsername(username).getShoppingListDtos();
        model.addAttribute("shoppingListDtos", shoppingListDtos);
        return "chart";
    }

}
