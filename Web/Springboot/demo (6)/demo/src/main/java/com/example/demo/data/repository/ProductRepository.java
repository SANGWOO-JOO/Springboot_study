package com.example.demo.data.repository;

import java.util.List;

import com.example.demo.data.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductRepository extends JpaRepository<Product, String> {

    /* 쿼리 메소드의 주제 키워드 */

    // 조회
//    List<Product> findByName(String name);
//    List<Product> queryByName(String name);


}