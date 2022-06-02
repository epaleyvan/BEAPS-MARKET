package com.beapsmarket.webapp.presentation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class PageController {

    @GetMapping("/")
    public String pageAccueil(Model model){
        return "index";
    }

    @GetMapping("/about")
    public String pageAbout(Model model){
        return "about";
    }

    @GetMapping("/account")
    public String account(Model model){
        return "account";
    }

    @GetMapping("/admin/dashboard")
    public String dashboard(Model model){
        return "dashboard";
    }
    @GetMapping("/admin/dashboard/user")
    public String userAdding(Model model){
        return "addUser";
    }
    @GetMapping("/admin/dashboard/product")
    public String userProduct(Model model){
        return "addProduct";
    }

}
