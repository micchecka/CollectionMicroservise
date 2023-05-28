package com.cinema.collection.service.back.dto.response;

public record CollectionResponseDto(Long id,
                                    String name,
                                    Long previewId,
                                    Integer countMovies,
                                    Integer countViewedMovies) {
}

