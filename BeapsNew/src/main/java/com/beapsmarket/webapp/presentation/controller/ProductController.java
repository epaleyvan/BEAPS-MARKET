package com.beapsmarket.webapp.presentation.controller;


import com.beapsmarket.webapp.model.dto.ProductDto;
import com.beapsmarket.webapp.service.IProduct;
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
public class ProductController {

    @Autowired
    IProduct iProduct;

    @GetMapping("/shop")
    public String getAllProducts(Model model){
        Set<ProductDto> productDtos = iProduct.searchAllProduct();
        model.addAttribute("productDtos", productDtos);
        return  "products";
    }

    @GetMapping("/detail")
    public String pageDetail(@RequestParam(name = "reference") String reference , Model model){
        ProductDto productDto = iProduct.searchProductByReference(reference);
        model.addAttribute("productDto", productDto);
        return "product__details";
    }

    @GetMapping("/supprimerproduits")
    public String pageSupprimer(@RequestParam(name="numero") String numero , Model model){
        iProduct.deleteProduct(numero);
        return "redirect:/products";
    }

    @GetMapping("/rechercherParCategories")
    public String pageproduits_categories(@RequestParam(value = "keyword") String keyword,Model model){

        /*Set<ProductDto> productDtos = iProduct.searchProductByCategory(keyword);
        model.addAttribute("productDtos",productDtos);
        return "products";*/
        return null;
    }

    @GetMapping("/rechercherproduits")
    public String rechercherProduits(@RequestParam(value ="keyword") String keyword,Model model){

        try{
            //faire en sorte que cela genere une exception
            ProductDto  productDto = iProduct.searchProductByReference(keyword);
            model.addAttribute("productDto",productDto);
        }catch (Exception e){
            System.out.println(e.getMessage());
            Set<ProductDto> productDtos = iProduct.searchProductByKeyword(keyword);
            model.addAttribute("productDtos",productDtos);

        }
        return "products";

    }

    @GetMapping("/produits/enregistrerform")
    public String enregistrerform(Model model){
        ProductDto productDto = new ProductDto();
        model.addAttribute("productDto",productDto);
        return "enregistrer-product";
    }

    @PostMapping("/produits/enregistrer")
    public String enregistrerproduits(@ModelAttribute ProductDto productDto, Model model){
        ProductController.log.info("enregistrer-product");
        iProduct.saveProduct(productDto);
        return "redirect:/dashboard";
    }


    @GetMapping("/produits/editerform")
    public String editerform(Model model){
        ProductDto productDto = new ProductDto();
        model.addAttribute("productDto",productDto);
        return "editer-product";
    }

    @PostMapping("/produits/editer")
    public String editerproduits(@ModelAttribute ProductDto productDto, Model model){
        ProductController.log.info("produit-editer");
        //ajouter la methode editer
        return "redirect:/dashboard";
    }
}

