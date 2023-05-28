package com.cinema.collection.service.back.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CollectionRequestDto(@NotBlank String name,
                                   @NotBlank Long categoryId) {
}
