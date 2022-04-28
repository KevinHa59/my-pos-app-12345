package com.th.pos.product.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double cost;
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "product_id")
//    private Product product;
    @OneToMany(mappedBy = "size", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<OrderDetail> order;
}