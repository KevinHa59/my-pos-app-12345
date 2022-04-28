package com.th.pos.product.service;

import com.th.pos.product.model.OrderDetail;
import com.th.pos.product.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository repository;

    public OrderDetail findOrderDetailById(Long id) {
        return repository.findOrderDetailById(id);
    }

    public List<OrderDetail> getAllOrderDetails() {
        return repository.findAll();
    }

    public OrderDetail addOrderDetail(OrderDetail data) {
        return repository.save(data);
    }

    public OrderDetail updateOrderDetail(OrderDetail data) {
        return repository.save(data);
    }

    public void deleteOrderDetailById(Long id) {
        repository.deleteById(id);
    }
}
