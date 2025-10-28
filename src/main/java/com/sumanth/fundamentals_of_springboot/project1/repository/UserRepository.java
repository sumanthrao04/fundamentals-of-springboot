package com.sumanth.fundamentals_of_springboot.project1.repository;

import com.sumanth.fundamentals_of_springboot.project1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
