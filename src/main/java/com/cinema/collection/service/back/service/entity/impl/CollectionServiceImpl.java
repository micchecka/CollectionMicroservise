package com.cinema.collection.service.back.service.entity.impl;

import com.cinema.collection.service.back.domain.Collection;
import com.cinema.collection.service.back.dto.SearchCollectionDto;
import com.cinema.collection.service.back.repository.CollectionRepository;
import com.cinema.collection.service.back.service.entity.CollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CollectionServiceImpl implements CollectionService {

    private final CollectionRepository collectionRepo;

    @Override
    @Transactional
    public void save(Collection collection) {
        collectionRepo.save(collection);
    }

    @Override
    public void update(Collection newCollection) {
        Collection collection = collectionRepo.findById(newCollection.getId()).orElseThrow();
        collection.setName(collection.getName());
        collection.setDescription(collection.getDescription());
        collection.setPreviewId(collection.getPreviewId());
        collection.setCategories(collection.getCategories());
        collectionRepo.save(collection);
    }

    @Override
    public boolean existCollection(Long id) {
        return collectionRepo.existsById(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        collectionRepo.deleteById(id);
    }

    @Override
    public List<SearchCollectionDto> getCollectionByName(String name, Pageable pageable) {
        return collectionRepo.getSearchCollectionDtoByName(name, pageable).getContent();
    }

    @Override
    public void activate(Long id) {
        Collection collection = collectionRepo.findById(id).orElseThrow();
        collection.setEnable(true);
        collectionRepo.save(collection);
    }

    @Override
    public void deactivate(Long id) {
        Collection collection = collectionRepo.findById(id).orElseThrow();
        collection.setEnable(false);
        collectionRepo.save(collection);
    }
}
