package com.example.demo.data.repository;


import com.example.demo.data.entity.Listener;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListenerRepository extends JpaRepository<Listener, Long> {

}