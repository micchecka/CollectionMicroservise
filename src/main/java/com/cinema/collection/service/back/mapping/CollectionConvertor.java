package com.cinema.collection.service.back.mapping;

import com.cinema.collection.service.back.domain.Collection;
import com.cinema.collection.service.back.dto.request.CollectionRequestDto;
import com.cinema.collection.service.back.repository.CollectionRepository;
import com.cinema.collection.service.back.service.entity.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CollectionConvertor {
    private final CollectionRepository collectionRepo;
    private final CategoriesService categoriesService;

    public Collection convertToCollection(CollectionRequestDto dto) {
        return Collection.builder()
                .name(dto.name())
                .categories(categoriesService.findById(dto.categoryId()))
                .build();
    }

    public Collection convertToCollection(CollectionRequestDto dto, long id) {
        Collection collection = collectionRepo.findById(id).orElseThrow();
        return Collection.builder()
                .id(id)
                .name(dto.name())
                .enable(true)
                .previewId(collection.getPreviewId())
                .description(collection.getDescription())
                .categories(categoriesService.findById(dto.categoryId()))
                .build();
    }
}
