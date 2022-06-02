package com.beapsmarket.webapp.presentation.api;


import com.beapsmarket.webapp.model.dto.ProductDto;
import com.beapsmarket.webapp.service.IProduct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductRestController {
    @Autowired
    IProduct iProduct;


    @PostMapping(value = "/save")
    public void saveProduct(@RequestBody ProductDto productDto) {
        ProductRestController.log.info("enregistrer-produit");
        iProduct.saveProduct(productDto);
    }

    @GetMapping("/{code}/delete")
    public  void deleteProduct(@PathVariable String code){
        iProduct.deleteProduct(code);
    }

    @GetMapping("/all")
    public ResponseEntity<Set<ProductDto>> getAllProduct(){
        return ResponseEntity.ok(iProduct.searchAllProduct());
    }

    @GetMapping("/{reference}/data")
    public ResponseEntity<ProductDto> getProductByReference(@PathVariable String reference) {
        return ResponseEntity.ok(iProduct.searchProductByReference(reference));
    }

    @GetMapping("/{name}/data")
    public ResponseEntity<Set<ProductDto>> getProductByName(@PathVariable String name ) {
        return ResponseEntity.ok(iProduct.searchProductByKeyword(name));
    }


}

