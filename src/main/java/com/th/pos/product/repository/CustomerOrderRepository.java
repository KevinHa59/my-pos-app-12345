package com.th.pos.product.repository;

import com.th.pos.product.model.CustomerOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
    CustomerOrder findCustomerOrderById(Long id);
    List<CustomerOrder> findAllByOrderDateBetween(LocalDateTime from, LocalDateTime to);
    Integer countAllByOrderDateBetween(LocalDateTime from, LocalDateTime to);
//    Page<CustomerOrder> findAllByOrderDateBetween(LocalDateTime from, LocalDateTime to, Pageable pageable);
//    Page<CustomerOrder> findAllBy(Pageable pageable);
//    List<CustomerOrder> findAllByOrderDate
}

