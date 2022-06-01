package com.beapsmarket.webapp.presentation.api;

import com.beapsmarket.webapp.model.dto.CategoryDto;
import com.beapsmarket.webapp.service.ICategory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/category")
@Slf4j
public class CatgeoryRestController {

    @Autowired
    ICategory iCategory;

    @PostMapping("/save")
    public void saveCategory(@RequestBody CategoryDto categoryDto){
        iCategory.saveCategory(categoryDto);
    }

    @GetMapping("/all")
    public ResponseEntity<Set<CategoryDto>> getAllCategory(){
        return ResponseEntity.ok(iCategory.findAllCategory());
    }

}
