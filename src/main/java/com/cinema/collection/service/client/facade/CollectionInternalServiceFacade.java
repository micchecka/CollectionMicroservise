package com.cinema.collection.service.client.facade;

import com.cinema.collection.service.back.dto.SearchCollectionDto;

import java.util.List;

public interface CollectionInternalServiceFacade {
    boolean isExistById(long id);

    List<SearchCollectionDto> getCollectionByName(String name);
}
