package com.th.pos.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderDate;
    private Integer invoiceNumber;
    private Integer orderNumber;
    private String orderStatus;
    private Double orderTotal;

    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.MERGE)
    private List<OrderDetail> orderItems;
}