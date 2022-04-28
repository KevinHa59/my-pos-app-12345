package com.th.pos.product.service;

import com.th.pos.product.model.CustomerOrder;
import com.th.pos.product.model.OrderDetail;
import com.th.pos.product.repository.CustomerOrderRepository;
import com.th.pos.product.repository.OrderDetailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class CustomerOrderService {

    @Autowired
    private CustomerOrderRepository repository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public CustomerOrder findCustomerOrderById(Long id) {
        return repository.findCustomerOrderById(id);
    }

    public List<CustomerOrder> getAllCustomerOrders() {
        return repository.findAll();
    }

//    public Page<CustomerOrder> getAllCustomerOrdersPageable(Integer pageNo, Integer pageSize, String sortBy, String orderDir, String from, String to){
//
//        String[] fromAr = from.split("-");
//        LocalDateTime f = LocalDateTime.of(Integer.parseInt(fromAr[0]), Integer.parseInt(fromAr[1]), Integer.parseInt(fromAr[2]), 0, 0);
//
//        String[] toAr = to.split("-");
//        LocalDateTime t = LocalDateTime.of(Integer.parseInt(toAr[0]), Integer.parseInt(toAr[1]), Integer.parseInt(toAr[2]), 23, 59);
//
//        System.out.println(f + " " + t);
//
//        if(orderDir.equals("ASC")){
//            Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(Sort.Direction.ASC));
//            return repository.findAllByOrderDateBetween(f,t,pageable);
//        }else {
//            Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(Sort.Direction.DESC));
//            return repository.findAllByOrderDateBetween(f,t,pageable);
//        }
//    }

    public List<CustomerOrder> getAllBetween(String from, String to){
        String[] fromAr = from.split("-");
        LocalDateTime f = LocalDateTime.of(Integer.parseInt(fromAr[0]), Integer.parseInt(fromAr[1]), Integer.parseInt(fromAr[2]), 0, 0);

        String[] toAr = to.split("-");
        LocalDateTime t = LocalDateTime.of(Integer.parseInt(toAr[0]), Integer.parseInt(toAr[1]), Integer.parseInt(toAr[2]), 23, 00);

//        LocalDateTime from = LocalDate.now().atTime(0,0);
//        LocalDateTime to = LocalDate.now().atTime(23,59);
        return repository.findAllByOrderDateBetween(f, t);
    }

    public  Integer todayRecordCount() {
        LocalDateTime from = LocalDate.now().atTime(0,00);
        LocalDateTime to = LocalDate.now().atTime(23,00);
        return repository.countAllByOrderDateBetween(from, to);
    }

    public CustomerOrder addCustomerOrder(CustomerOrder data) {
        if(data.getId() == null){
            System.out.println(">>>>>>>>>>>>>>>> ADd id: "+data.getId());
        List<OrderDetail> orderDetails = data.getOrderItems();


        data.setOrderItems(null);
        data.setOrderStatus("Waiting");
        data.setOrderNumber(todayRecordCount() + 1);
        data.setOrderDate(LocalDateTime.now());

        CustomerOrder customerOrder = repository.save(data);

        orderDetails.forEach((item) -> {
            item.setCustomerOrder(customerOrder);
        });
        orderDetailRepository.saveAll(orderDetails);
        return customerOrder;
        }else {
            System.out.println(">>>>>>>>>>>>>>>> Update id: "+data.getId());
            return repository.save(data);
        }
    }

    public CustomerOrder updateCustomerOrder(CustomerOrder data) {
        return repository.save(data);
    }

    public void deleteCustomerOrderById(Long id) {
        repository.deleteById(id);
    }
}
