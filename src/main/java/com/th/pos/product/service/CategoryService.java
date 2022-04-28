package com.th.pos.product.service;

import com.th.pos.product.model.Category;
import com.th.pos.product.model.CategoryProduct;
import com.th.pos.product.model.Product;
import com.th.pos.product.repository.CategoryRepository;
import com.th.pos.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private ProductRepository productRepository;

    public Category findCategoryById(Long id) {
        return repository.findCategoryById(id);
    }

    public List<Category> getAllCategorys() {
        return repository.findAll();
    }

    public List<CategoryProduct> getAllCateProducts(){
        List<CategoryProduct> list = new ArrayList<>();
        List<Category> categories = repository.findAll();

        for (Category category : categories) {
            CategoryProduct categoryProduct = new CategoryProduct();
            List<Product> p = productRepository.findAllByCategory_Id(category.getId());
            categoryProduct.setId(category.getId());
            categoryProduct.setName(category.getName());
            categoryProduct.setProducts(p);
            list.add(categoryProduct);
        }

        return list;

    }

    public Category addCategory(Category data) {
        return repository.save(data);
    }

    public Category updateCategory(Category data) {
        return repository.save(data);
    }

    public void deleteCategoryById(Long id) {
        repository.deleteById(id);
    }
}
