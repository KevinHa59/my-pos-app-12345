package com.th.pos.product.controller;

import com.th.pos.product.model.Product;
import com.th.pos.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/find/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findProductById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/group")
    public  List<Product> getALlProductsByCategoryId(@RequestParam("cateid") Long id, @RequestParam("orderBy") String by, @RequestParam("dir") String dir){
        return service.getALlProductsByCategoryId(id,by, dir);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product data) {
        return new ResponseEntity<>(service.addProduct(data), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product data) {
        return new ResponseEntity<>(service.updateProduct(data), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable("id") Long id) {
        service.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}