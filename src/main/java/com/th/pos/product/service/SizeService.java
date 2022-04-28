package com.th.pos.product.service;

import com.th.pos.product.model.Size;
import com.th.pos.product.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SizeService {

    @Autowired
    private SizeRepository repository;

    public Size findSizeById(Long id) {
        return repository.findSizeById(id);
    }

    public List<Size> getAllSizes() {
        return repository.findAll();
    }

    public Size addSize(Size data) {
        return repository.save(data);
    }

    public Size updateSize(Size data) {
        return repository.save(data);
    }

    public void deleteSizeById(Long id) {
        repository.deleteById(id);
    }
}
