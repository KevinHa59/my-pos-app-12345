package com.th.pos.product.controller;

import com.th.pos.product.model.OrderDetail;
import com.th.pos.product.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/orderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService service;

    @GetMapping("/find/{id}")
    public ResponseEntity<OrderDetail> findOrderDetailById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findOrderDetailById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderDetail>> getAllOrderDetails() {
        return new ResponseEntity<>(service.getAllOrderDetails(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<OrderDetail> addOrderDetail(@RequestBody OrderDetail data) {
        return new ResponseEntity<>(service.addOrderDetail(data), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<OrderDetail> updateOrderDetail(@RequestBody OrderDetail data) {
        return new ResponseEntity<>(service.updateOrderDetail(data), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrderDetailById(@PathVariable("id") Long id) {
        service.deleteOrderDetailById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}