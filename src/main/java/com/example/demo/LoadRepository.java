package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface LoadRepository extends JpaRepository<Load, Long> {
    @Query("SELECT p FROM  Load p WHERE CONCAT(p.name_load, ' ', p.content, ' ', p.city_from , ' ', p.city_to, ' ',p.data_input, ' ',p.data_output) LIKE %?1%")
    List<Load> search(String keyword);


}