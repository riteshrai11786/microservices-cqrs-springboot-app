package com.ritesh.products.command.api.repository;

import com.ritesh.products.command.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
