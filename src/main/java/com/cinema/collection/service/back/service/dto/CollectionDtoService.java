package com.cinema.collection.service.back.service.dto;

import com.cinema.collection.service.back.dto.response.CollectionResponseDto;

import java.util.List;

public interface CollectionDtoService {
    CollectionResponseDto getCollectionById(Long id);

    List<CollectionResponseDto> getAll();
}
