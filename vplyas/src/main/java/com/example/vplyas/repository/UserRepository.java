package com.example.vplyas.repository;

import com.example.vplyas.entity.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByName(String name);
}
