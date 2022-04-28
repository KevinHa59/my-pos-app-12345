package com.th.pos.product.controller;

import com.th.pos.product.model.Category;
import com.th.pos.product.model.CategoryProduct;
import com.th.pos.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/find/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findCategoryById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Category>> getAllCategorys() {
        return new ResponseEntity<>(service.getAllCategorys(), HttpStatus.OK);
    }

    @GetMapping("/cate&prod")
    public ResponseEntity<List<CategoryProduct>> getAllCateProducts() {
        return new ResponseEntity<>(service.getAllCateProducts(), HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category data) {
        return new ResponseEntity<>(service.addCategory(data), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Category> updateCategory(@RequestBody Category data) {
        return new ResponseEntity<>(service.updateCategory(data), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable("id") Long id) {
        service.deleteCategoryById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}