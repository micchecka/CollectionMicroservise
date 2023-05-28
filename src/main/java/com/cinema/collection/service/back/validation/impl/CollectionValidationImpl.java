package com.cinema.collection.service.back.validation.impl;

import com.cinema.collection.service.back.repository.CollectionRepository;
import com.cinema.collection.service.back.validation.CollectionValidation;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CollectionValidationImpl implements CollectionValidation {
    private final CollectionRepository collectionRepo;

    @Override
    public void isExistById(long id) {
        log.debug("Start validation collection is exist with id = {}", id);

        if (!collectionRepo.existsById(id)) {
            log.error("collection not exist with id = {}", id);
            throw new EntityNotFoundException(String.format("Collection с таким id = %s не найден", id));
        }

        log.info("Success validation, collection with id = {} exist ", id);
    }
}
