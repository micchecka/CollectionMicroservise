package com.cinema.collection.service.back.service.entity.impl;

import com.cinema.collection.service.back.domain.Categories;
import com.cinema.collection.service.back.repository.CategoriesRepository;
import com.cinema.collection.service.back.service.entity.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesServiceImpl implements CategoriesService {
    private final CategoriesRepository categoriesRepo;

    @Autowired
    public CategoriesServiceImpl(CategoriesRepository categoriesRepo) {
        this.categoriesRepo = categoriesRepo;
    }

    @Override
    public Categories findById(Long id) {
        return categoriesRepo.findById(id).orElseThrow();
    }
}
