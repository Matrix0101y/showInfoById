package com.example.showinfoproject.data.repository;

import com.example.showinfoproject.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findById(String name);
}
