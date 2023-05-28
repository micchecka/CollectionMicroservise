package com.cinema.collection.service.rest.internal;

import com.cinema.collection.service.back.dto.SearchCollectionDto;
import com.cinema.collection.service.rest.SpringContextTest;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import java.util.ArrayList;
import java.util.Arrays;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, value = "/db/scripts/rest/internal/AccountInternalRestController/before.sql")
@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, value = "/db/scripts/rest/internal/AccountInternalRestController/after.sql")
@SpringBootTest
@AutoConfigureMockMvc
public class CollectionInternalRestControllerTest extends SpringContextTest {

    /**
     * ТЕСТ-КЕЙС
     * коллекция существует
     **/

    @Test
    public void givenId_whenIsExist_thenIsExistById() throws Exception {
        mockMvc.perform(get("/api/internal/collection/{id}/exists", 100)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Is.is(true)));
    }

    /**
     * ТЕСТ-КЕЙС
     * коллекция не существует
     **/

    @Test
    public void givenId_whenNotIsExist_thenIsExistById_() throws Exception {
        mockMvc.perform(get("/api/internal/collection/{id}/exists", 109)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Is.is(false)));
    }

    /**
     * ТЕСТ-КЕЙС
     * попытка получения существующей коллекции по имени
     **/

    @Test
    public void getCollectionByName_whenIsExist_thenIsExistByName_() throws Exception {

        mockMvc.perform(get("/api/internal/search?filterPattern=collection")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(
                        new SearchCollectionDto("collection100", "0", 2L),
                        new SearchCollectionDto("collection101", "0", 1L),
                        new SearchCollectionDto("collection102", "0", 3L)))));

    }

    /**
     * ТЕСТ-КЕЙС
     * попытка получения несуществующей коллекции по имени
     **/

    @Test
    public void getCollectionByName_whenNotIsExist_thenIsNotExistByName_() throws Exception {
        mockMvc.perform(get("/api/internal/search?filterPattern=collection110")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Is.is(new ArrayList())));
    }
}
