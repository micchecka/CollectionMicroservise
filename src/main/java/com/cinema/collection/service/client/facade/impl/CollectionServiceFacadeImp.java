package com.cinema.collection.service.client.facade.impl;

import com.cinema.collection.service.back.domain.Collection;
import com.cinema.collection.service.back.dto.SearchCollectionDto;
import com.cinema.collection.service.back.dto.request.CollectionRequestDto;
import com.cinema.collection.service.back.dto.response.CollectionResponseDto;
import com.cinema.collection.service.back.mapping.CollectionConvertor;
import com.cinema.collection.service.back.service.dto.CollectionDtoService;
import com.cinema.collection.service.back.service.entity.CollectionService;
import com.cinema.collection.service.back.validation.CollectionValidation;
import com.cinema.collection.service.client.facade.CollectionInternalServiceFacade;
import com.cinema.collection.service.client.facade.CollectionServiceFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CollectionServiceFacadeImp implements CollectionInternalServiceFacade, CollectionServiceFacade {

    private final CollectionService collectionService;
    private final CollectionDtoService collectionDtoService;
    private final CollectionValidation collectionValidation;
    private final CollectionConvertor collectionConvertor;


    @Override
    public boolean isExistById(long id) {
        return collectionService.existCollection(id);
    }

    @Override
    public List<SearchCollectionDto> getCollectionByName(String name) {
        Pageable pageable = PageRequest.of(0, 3);
        return collectionService.getCollectionByName(name, pageable);
    }

    @Override
    public List<CollectionResponseDto> getAll() {
        return collectionDtoService.getAll();
    }

    @Override
    public CollectionResponseDto getCollectionById(long id) {
        return collectionDtoService.getCollectionById(id);
    }

    @Override
    public void save(CollectionRequestDto collectionRequestDto) {
        Collection collection = collectionConvertor.convertToCollection(collectionRequestDto);
        collectionService.save(collection);
    }

    @Override
    public void update(long id, CollectionRequestDto collectionRequestDto) {
        collectionValidation.isExistById(id);
        Collection collection = collectionConvertor.convertToCollection(collectionRequestDto, id);
        collectionService.update(collection);
    }

    @Override
    public void delete(long id) {
        collectionValidation.isExistById(id);
        collectionService.deleteById(id);
    }

    @Override
    public void activate(long id) {
        collectionValidation.isExistById(id);
        collectionService.activate(id);
    }

    @Override
    public void deactivate(long id) {
        collectionValidation.isExistById(id);
        collectionService.deactivate(id);
    }
}
