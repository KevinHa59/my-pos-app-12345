package com.th.pos.product.repository;

import com.th.pos.product.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductById(Long id);
    List<Product> findAllByCategory_Id(Long id, Sort sort);
    List<Product> findAllByCategory_Id(Long id);
}

