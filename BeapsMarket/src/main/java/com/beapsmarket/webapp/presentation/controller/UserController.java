package com.beapsmarket.webapp.presentation.controller;


import com.beapsmarket.webapp.service.IUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
public class UserController {
    @Autowired
    IUser iUser;


    @GetMapping("/")
    public String pageAccueil(Model model){

        return "index";
    }


}
