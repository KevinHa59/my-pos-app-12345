package com.th.pos.product;

import com.th.pos.product.model.Product;
import com.th.pos.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class ProductApplication {


    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);

    }

}
