package com.cinema.collection.service.client.rest.internal;

import com.cinema.collection.service.back.dto.SearchCollectionDto;
import com.cinema.collection.service.client.facade.CollectionInternalServiceFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@RestController
@RequestMapping("/api/internal")
@RequiredArgsConstructor
public class CollectionInternalRestController {

    private final CollectionInternalServiceFacade collectionInternalServiceFacade;

    @GetMapping("/collection/{id}/exists")
    public ResponseEntity<Boolean> showCollection(@PathVariable Long id) {
        return ResponseEntity.ok(collectionInternalServiceFacade.isExistById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<SearchCollectionDto>> getCollectionByName(@RequestParam("filterPattern") String name) {
        return ResponseEntity.ok(collectionInternalServiceFacade.getCollectionByName(name));
    }

}
