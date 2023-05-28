package com.cinema.collection.service.client.rest.out;

import com.cinema.collection.service.back.dto.request.CollectionRequestDto;
import com.cinema.collection.service.back.dto.response.CollectionResponseDto;
import com.cinema.collection.service.client.facade.CollectionMovieServiceFacade;
import com.cinema.collection.service.client.facade.CollectionServiceFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;


import java.util.List;

@RestController
@RequestMapping("/api/collections")
@RequiredArgsConstructor
@Validated
public class CollectionRestController {
    private final CollectionServiceFacade collectionServiceFacade;
    private final CollectionMovieServiceFacade collectionMovieServiceFacade;

    @GetMapping
    public ResponseEntity<List<CollectionResponseDto>> listAllCollections() {
        return ResponseEntity.ok(collectionServiceFacade.getAll());
    }

    @GetMapping(params = {"id"})
    public ResponseEntity<CollectionResponseDto> getCollectionById(@RequestParam Long id) {
        return ResponseEntity.ok(collectionServiceFacade.getCollectionById(id));
    }

    @PostMapping
    public ResponseEntity<Void> saveCollection(@Valid @RequestBody CollectionRequestDto requestDto) {
        collectionServiceFacade.save(requestDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCollection(@PathVariable Long id,
                                                 @RequestBody CollectionRequestDto requestDto) {
        collectionServiceFacade.update(id, requestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollection(@PathVariable Long id) {
        collectionServiceFacade.delete(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/activate")
    public ResponseEntity<Void> activate(@PathVariable Long id) {
        collectionServiceFacade.activate(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        collectionServiceFacade.deactivate(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/movies")
    public ResponseEntity<Void> addMovies(@PathVariable("id") Long collectionId,
                                          @RequestBody List<Long> movieIds) {
        collectionMovieServiceFacade.addMovies(collectionId, movieIds);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/movies")
    public ResponseEntity<Void> removeMovies(@PathVariable("id") Long collectionId,
                                             @RequestBody List<Long> movieIds) {
        collectionMovieServiceFacade.removeMovies(collectionId, movieIds);
        return ResponseEntity.ok().build();
    }
}
