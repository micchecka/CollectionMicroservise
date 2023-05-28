package com.cinema.collection.service.back.repository;

import com.cinema.collection.service.back.domain.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {
}
