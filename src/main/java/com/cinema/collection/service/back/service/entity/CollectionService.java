package com.cinema.collection.service.back.service.entity;

import com.cinema.collection.service.back.domain.Collection;
import com.cinema.collection.service.back.dto.SearchCollectionDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CollectionService {

    void save(Collection collection);

    void update(Collection collection);

    void deleteById(Long id);

    boolean existCollection(Long id);

    List<SearchCollectionDto> getCollectionByName(String name, Pageable pageable);

    void activate(Long id);

    void deactivate(Long id);
}
