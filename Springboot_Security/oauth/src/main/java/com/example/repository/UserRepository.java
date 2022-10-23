package com.example.repository;

import com.example.document.User;

import java.util.Optional;

public interface UserRepository extends MARIAA<User, String> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}