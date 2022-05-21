package com.example.th2_nhom14.repositories;

import com.example.th2_nhom14.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositories extends JpaRepository<Product,String> {
}
