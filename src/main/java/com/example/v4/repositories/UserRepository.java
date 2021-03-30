package com.example.v4.repositories;

import com.example.v4.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findUsersByUserName(String userName);
}
