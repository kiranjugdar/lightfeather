package io.lightfeather.management.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.lightfeather.management.model.UserDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ManagementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSupervisors() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/supervisors"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0]").isString());
    }

    @Test
    public void testSubmit() throws Exception {
        UserDetails userDetails = new UserDetails("First", "Last", "Supervisor", null, null);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/submit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.convertObjectToJsonBytes(userDetails)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testSubmitWithMissingParameters() throws Exception {
        UserDetails userDetails = UserDetails.builder()
                .firstName("John")
                .build();
        this.mockMvc.perform(post("/api/submit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.convertObjectToJsonBytes(userDetails)))
                .andExpect(status().isBadRequest());
    }
}

class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static byte[] convertObjectToJsonBytes(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsBytes(object);
    }
}

