package com.cinema.collection.service.client.facade;

import com.cinema.collection.service.back.dto.request.CollectionRequestDto;
import com.cinema.collection.service.back.dto.response.CollectionResponseDto;

import java.util.List;

public interface CollectionServiceFacade {

    List<CollectionResponseDto> getAll();

    CollectionResponseDto getCollectionById(long id);

    void save(CollectionRequestDto collectionRequestDto);

    void update(long id, CollectionRequestDto collectionRequestDto);

    void delete(long id);

    void activate(long id);

    void deactivate(long id);
}
