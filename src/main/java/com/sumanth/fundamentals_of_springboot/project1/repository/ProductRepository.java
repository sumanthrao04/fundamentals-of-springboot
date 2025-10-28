package com.sumanth.fundamentals_of_springboot.project1.repository;

import com.sumanth.fundamentals_of_springboot.project1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
