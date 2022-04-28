package com.th.pos.product.controller;

import com.th.pos.product.model.Size;
import com.th.pos.product.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/size")
public class SizeController {

    @Autowired
    private SizeService service;

    @GetMapping("/find/{id}")
    public ResponseEntity<Size> findSizeById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findSizeById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Size>> getAllSizes() {
        return new ResponseEntity<>(service.getAllSizes(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Size> addSize(@RequestBody Size data) {
        return new ResponseEntity<>(service.addSize(data), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Size> updateSize(@RequestBody Size data) {
        return new ResponseEntity<>(service.updateSize(data), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSizeById(@PathVariable("id") Long id) {
        service.deleteSizeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}