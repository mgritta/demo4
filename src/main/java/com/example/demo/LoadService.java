package com.example.demo;

import groovy.transform.ASTTest;
import org.springframework.beans.factory.annotation.Autowired; // для связи всех зависимостей в классах
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadService {
    @Autowired
    private LoadRepository repo;

    public List<Load> listAll(String keyword){
        if (keyword != null){
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    public void save(Load load){
        repo.save(load);
    }

    public Load get(Long id){
        return repo.findById(id).get();
    }

    public void delete(Long id){
        repo.deleteById(id);
    }

//    public void sortByColumn() {
//        Sort sort = Sort.by()
//
//    }
}