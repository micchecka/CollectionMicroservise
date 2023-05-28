package com.cinema.collection.service.client.facade.impl;

import com.cinema.collection.service.back.domain.Collection;
import com.cinema.collection.service.back.repository.CollectionRepository;
import com.cinema.collection.service.client.facade.CollectionMovieServiceFacade;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CollectionMovieServiceFacadeImp implements CollectionMovieServiceFacade {


 private CollectionRepository collectionRepository;

    @Override
    public void addMovies(Long collectionId, List<Long> movieIds) {
    Collection collection = collectionRepository.findById(collectionId);
    }

    @Override
    public void removeMovies(Long collectionId, List<Long> movieIds) {

    }
}
