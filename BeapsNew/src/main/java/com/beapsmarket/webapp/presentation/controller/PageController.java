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

}
