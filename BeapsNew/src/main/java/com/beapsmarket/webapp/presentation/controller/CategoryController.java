package com.beapsmarket.webapp.presentation.controller;

import com.beapsmarket.webapp.model.dto.ProductDto;
import com.beapsmarket.webapp.service.ICategory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
@Slf4j
public class CategoryController {
    @Autowired
    ICategory iCategory;

    @GetMapping("/shopbycategory")
    public String getCategoryProducts(@RequestParam(name = "reference") String reference, Model model){
        Set<ProductDto> productDtos = iCategory.findCategoryByReference(reference).getProductDtos();
        model.addAttribute("productDtos", productDtos);
        return "products";
    }
}
