package com.sumanth.fundamentals_of_springboot.project2.repository;

import com.sumanth.fundamentals_of_springboot.project2.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {

}
