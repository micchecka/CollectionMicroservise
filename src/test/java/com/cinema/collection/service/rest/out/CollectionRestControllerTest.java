package com.cinema.collection.service.rest.out;

import com.cinema.collection.service.back.domain.Categories;
import com.cinema.collection.service.back.domain.Collection;
import com.cinema.collection.service.back.dto.request.CollectionRequestDto;
import com.cinema.collection.service.rest.SpringContextTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, value = "/db/scripts/rest/internal/CollectionRestController/before.sql")
@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, value = "/db/scripts/rest/internal/CollectionRestController/after.sql")
@SpringBootTest
@AutoConfigureMockMvc
public class CollectionRestControllerTest extends SpringContextTest {

    /**
     * ТЕСТ-КЕЙС
     * успешное изменение коллекции
     **/

    @Test
    public void updateCollection_success() throws Exception {
        CollectionRequestDto dto = CollectionRequestDto.builder()
                .name("collection101")
                .categoryId(101L)
                .build();
        Categories categories = new Categories(101L, "categoriesName2");

        mockMvc.perform(put("/api/collection/{id}", 100)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());

        Collection collection = entityManager.find(Collection.class, 100);
        assertEquals(collection.getId(), 100);
        assertEquals(collection.getName(), dto.name());
        assertTrue(collection.isEnable());
        assertEquals(collection.getPreviewId(), 100);
        assertEquals(collection.getDescription(), "description");
        assertEquals(collection.getCategories().getId(), categories.getId());
        assertEquals(collection.getCategories().getName(), categories.getName());
    }

    /**
     * ТЕСТ-КЕЙС
     * успешное сохранение коллекции
     **/

    @Test
    public void saveCollection_success() throws Exception {
        CollectionRequestDto dto = CollectionRequestDto.builder()
                .name("collection110")
                .categoryId(101L)
                .build();
        Categories categories = new Categories(101L, "categoriesName2");

        mockMvc.perform(post("/api/collection")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());

        Collection collection = entityManager.find(Collection.class, 1);
        assertEquals(collection.getId(), 1);
        assertEquals(collection.getName(), dto.name());
        assertTrue(collection.isEnable());
        assertEquals(collection.getPreviewId(), 100);
        assertEquals(collection.getDescription(), "description");
        assertEquals(collection.getCategories().getId(), categories.getId());
        assertEquals(collection.getCategories().getName(), categories.getName());
    }

}
