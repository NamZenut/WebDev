package com.example.WebDev.Repository;

import com.example.WebDev.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String userName);
}
