package com.th.pos.product.controller;

import com.th.pos.product.model.CustomerOrder;
import com.th.pos.product.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/customerOrder")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService service;

    @GetMapping("/find/{id}")
    public ResponseEntity<CustomerOrder> findCustomerOrderById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findCustomerOrderById(id), HttpStatus.OK);
    }

    @GetMapping("/all/between")
    public List<CustomerOrder> getAllBetween(
            @RequestParam("from") String from,
            @RequestParam("to") String to){

        return service.getAllBetween(from, to);
    }

    @GetMapping("/")
    public ResponseEntity<List<CustomerOrder>> getAllCustomerOrders() {
        return new ResponseEntity<>(service.getAllCustomerOrders(), HttpStatus.OK);
    }

//    @GetMapping("/allOrders")
//    public Page<CustomerOrder> getAllCustomerOrdersPageable(
//            @RequestParam("from") String from,
//            @RequestParam("to") String to,
//            @RequestParam("pageNo") Integer pageNo,
//            @RequestParam("pageSize") Integer pageSize,
//            @RequestParam("sortBy") String sortBy,
//            @RequestParam("sortDir") String sortDir){
//
//        return service.getAllCustomerOrdersPageable(pageNo,pageSize , sortBy,sortDir, from, to);
//    }

    @PostMapping("/add")
    public ResponseEntity<CustomerOrder> addCustomerOrder(@RequestBody CustomerOrder data) {
        return new ResponseEntity<>(service.addCustomerOrder(data), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerOrder> updateCustomerOrder(@RequestBody CustomerOrder data) {
        return new ResponseEntity<>(service.updateCustomerOrder(data), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomerOrderById(@PathVariable("id") Long id) {
        service.deleteCustomerOrderById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}