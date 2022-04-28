package com.th.pos.product.service;

import com.th.pos.product.model.Product;
import com.th.pos.product.model.Size;
import com.th.pos.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product findProductById(Long id) {
        return repository.findProductById(id);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public  List<Product> getALlProductsByCategoryId(Long id,String by, String order){
        Sort sort = null;
        if(order.equals("ASC")){
            sort = Sort.by(Sort.Direction.ASC, by);
        }else if(order.equals("DESC")){
            sort = Sort.by(Sort.Direction.DESC, by);
        }else {
            return repository.findAllByCategory_Id(id);
        }
        return repository.findAllByCategory_Id(id, sort);
    }

    public Product addProduct(Product data) {
        return repository.save(data);
    }

    public Product updateProduct(Product data) {
        return repository.save(data);
    }

    public void deleteProductById(Long id) {
        repository.deleteById(id);
    }
}
