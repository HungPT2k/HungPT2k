package com.example.th2_nhom14.service;

import com.example.th2_nhom14.model.Product;
import com.example.th2_nhom14.repositories.ProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    @Autowired
    private ProductRepositories repo;

    public List<Product> getAll() {
        return repo.findAll();
    }

    public void save(Product product) {
        repo.save(product);
    }

    public Optional<Product> get(String id) {
        return repo.findById(id);
    }

    public void delete(String id) {
        repo.deleteById(id);
    }
}
