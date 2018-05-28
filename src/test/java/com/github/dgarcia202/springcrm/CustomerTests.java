package com.github.dgarcia202.springcrm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void ListsAllCustomers() throws Exception {
        mockMvc.perform(get("/customers"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(10)));
    }

    @Test
    public void CustomerCreationRedirects() throws Exception {
        mockMvc.perform(post("/customers")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{ \"name\":\"Google Inc.\" }"))
                .andDo(print())
                .andExpect(redirectedUrlPattern("http://localhost/customers/*"));
    }

    @Test
    public void CreatesCustomers() throws Exception {
        mockMvc.perform(post("/customers")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{ \"name\":\"Amazon Inc.\" }"))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void GetsSpecificCustomer() throws Exception {
        mockMvc.perform(get("/customers/1000"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.name").value("Dablist"))
                .andExpect(jsonPath("$.status.id").value(3));
    }

    @Test
    public void GetNonExistemntCustomerReturnsNotFound() throws Exception {
        mockMvc.perform(get("/customers/99999"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
