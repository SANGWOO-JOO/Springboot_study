package com.example.ORM.ORM.Repository;

import com.example.ORM.ORM.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}