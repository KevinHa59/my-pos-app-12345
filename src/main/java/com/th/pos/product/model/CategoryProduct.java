package com.th.pos.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryProduct {

    private Long id;
    private String name;
    private List<Product> products;
}
