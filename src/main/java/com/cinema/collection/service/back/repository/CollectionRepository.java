package com.cinema.collection.service.back.repository;

import com.cinema.collection.service.back.domain.Collection;
import com.cinema.collection.service.back.dto.SearchCollectionDto;
import com.cinema.collection.service.back.dto.response.CollectionResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long> {
    
     @Query("SELECT new com.cinema.collection.service.back.dto.response.CollectionResponseDto(" +
            "c.id, c.name, c.previewId, (SELECT count(m) FROM CollectionMovie m WHERE m.collection.id = c.id), 0) from Collection c  where c.id = :id")
    CollectionResponseDto getCollectionDtoById(Long id);

    @Query("SELECT new com.cinema.collection.service.back.dto.response.CollectionResponseDto(" +
            "c.id, c.name, c.previewId, (SELECT count(m) FROM CollectionMovie m WHERE m.collection.id = c.id), 0) from Collection c")
    List<CollectionResponseDto> getAllCollectionDto();

   // @Query("SELECT new com.cinema.collection.service.back.dto.response.CollectionResponseDto(" +
//             "c.id, c.name, c.previewId, (SELECT count(m) FROM CollectionMovie m WHERE m.collection.id = :id )," +
//     " (SELECT count(m) FROM UserCollection m WHERE m.collection.id = :id )) from Collection c where  c.id = :id")
//     CollectionResponseDto getCollectionDtoById(Long id);

//     @Query("SELECT new com.cinema.collection.service.back.dto.response.CollectionResponseDto(" +
//             "c.id, c.name, c.previewId, (SELECT count(m) FROM CollectionMovie m WHERE m.collection.id = :id )," +
//     "(SELECT count(m) FROM UserCollection m WHERE m.collection.id = :id )) from Collection c ")
//     List<CollectionResponseDto> getAllCollectionDto();

    @Query(value = """
            SELECT new com.cinema.collection.service.back.dto.SearchCollectionDto(
            c.name,
            :url,
            (SELECT COUNT(m) FROM CollectionMovie m WHERE m.collection.id = c.id))
            FROM Collection c
            WHERE LOWER(c.name) LIKE LOWER(CONCAT('%',:name,'%'))
            """,
            countQuery = """
                            SELECT COUNT(c) 
                            FROM Collection c 
                            WHERE LOWER(c.name) LIKE LOWER(CONCAT('%',:name,'%'))
                            """)
    Page<SearchCollectionDto> getSearchCollectionDtoByName (String name, Pageable pageable);
}
