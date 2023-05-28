package com.cinema.collection.service.client.facade;

import java.util.List;

public interface CollectionMovieServiceFacade {
    void addMovies(Long collectionId, List<Long> movieIds);

    void removeMovies(Long collectionId, List<Long> movieIds);
}
