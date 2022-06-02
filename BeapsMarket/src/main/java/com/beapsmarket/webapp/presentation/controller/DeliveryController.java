package com.beapsmarket.webapp.presentation.controller;

import com.beapsmarket.webapp.model.dto.DeliveryDto;
import com.beapsmarket.webapp.service.IDelivery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
@Slf4j
public class DeliveryController {

    @Autowired
    IDelivery iDelivery;




    @GetMapping("/listDelivery")
    public String pageDelivery(Model model){
        Set<DeliveryDto> deliveryDtos = iDelivery.findAllDelivery();
        model.addAttribute("deliveryDtos",deliveryDtos);
        return "deliveryPage";

    }

    @PostMapping("/delivery/rechercher")
    public String rechercherdelivery(@RequestParam(value="keyword") String keyword, Model model){
        DeliveryDto deliveryDto = iDelivery.findDeliveryByReference(keyword);
        model.addAttribute("deliveryDto",deliveryDto);
        return "rechercherDelivery";
    }


}
