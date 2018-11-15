package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserControllerTest {

    private MockMvc mvc;

    @Before
    public void init() throws Exception{
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build() ;
    }

    @Test
    public void testGetUser() throws Exception {
        String url = String.format("/users/%d",1);
        log.info(url);
        mvc.perform(get(url).contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk());
        log.info("PASS!");
    }

    @Test
    public void testGetUserListTest() throws Exception {
        String url = "/users/list";
        log.info(url);
        mvc.perform(get(url).contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk());
        log.info("PASS");
    }

    @Test
    public void createUser() throws Exception{
        String url = "/users/create";
        mvc.perform(post(url).param("id","1")
                .param("username","Flash")
                .contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk());
        log.info("PASS!");
    }

    @Test
    public void putUserTest()throws Exception{
        String url1 = "/users/create";
        mvc.perform(post(url1).param("id","1")
                .param("username","Flash")
                .contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk());

        String url =String.format("/users/%d",1);
        log.info(url);
        mvc.perform(put(url)
                .param("age","28"))
                .andExpect(content().string(equalTo("success")));
        log.info("PASS!");
    }

    @Test
    public void deleteTest() throws Exception{
        String url1 = "/users/create";
        mvc.perform(post(url1).param("id","1")
                .param("username","Flash")
                .contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk());
        String url = String.format("/users/%d",1);
        mvc.perform(delete(url)).andExpect(status().isOk());
    }
}
