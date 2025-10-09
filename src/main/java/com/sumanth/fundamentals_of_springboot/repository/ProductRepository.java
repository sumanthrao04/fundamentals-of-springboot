package com.sumanth.fundamentals_of_springboot.repository;

import com.sumanth.fundamentals_of_springboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
