package com.century.recommendation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(value = "/populateDBTest.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class RecommendationRestControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getRecommendation() throws Exception {
        this.mockMvc.perform(get("/rest/recommendation/100005"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getNewRecommendation() throws Exception {
        this.mockMvc.perform(get("/rest/recommendation/100001"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getNoExistUser() throws Exception {
        this.mockMvc.perform(get("/rest/recommendation/105001"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
