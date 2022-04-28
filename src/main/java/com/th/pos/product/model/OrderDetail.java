package com.th.pos.product.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id")
    private Product product;
    private Double productCost;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "size_id")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Size size;
    private Double sizeCost;
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_order_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CustomerOrder customerOrder;
}