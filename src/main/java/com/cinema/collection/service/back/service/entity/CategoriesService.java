package com.cinema.collection.service.back.service.entity;

import com.cinema.collection.service.back.domain.Categories;

import java.util.List;
import java.util.Optional;

public interface CategoriesService {

    Categories findById(Long id);
}
