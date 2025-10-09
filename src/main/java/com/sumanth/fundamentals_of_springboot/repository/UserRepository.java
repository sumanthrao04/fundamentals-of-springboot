package com.sumanth.fundamentals_of_springboot.repository;

import com.sumanth.fundamentals_of_springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
