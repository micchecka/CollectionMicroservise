package com.cinema.collection.service.back.service.dto.Impl;

import com.cinema.collection.service.back.dto.response.CollectionResponseDto;
import com.cinema.collection.service.back.repository.CollectionRepository;
import com.cinema.collection.service.back.service.dto.CollectionDtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CollectionDtoServiceImp implements CollectionDtoService {
    private final CollectionRepository collectionRepo;

    @Override
    public CollectionResponseDto getCollectionById(Long id) {
        return collectionRepo.getCollectionDtoById(id);
    }

    @Override
    public List<CollectionResponseDto> getAll() {
        return collectionRepo.getAllCollectionDto();
    }
}
