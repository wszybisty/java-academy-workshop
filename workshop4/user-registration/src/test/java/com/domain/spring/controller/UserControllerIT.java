package com.domain.spring.controller;

import com.domain.spring.config.TestAppConfig;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 *
 * @author wszybisty
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestAppConfig.class})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@WebAppConfiguration
public class UserControllerIT {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setupTest() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    @DatabaseSetup("empty.ds.xml")
    public void getUsers_emptyTable_shouldReturnNoRecords() throws Exception {
        ResultActions perform = mvc.perform(get("/users"));

        perform.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    @DatabaseSetup("UserControllerIT.ds.populated.xml")
    public void getUsers_thereAreRecordsInUserTable_shouldReturnRecords() throws Exception {
        ResultActions perform = mvc.perform(get("/users"));

        perform.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].userId", equalTo(1)));
    }

    @Test
    @DatabaseSetup("empty.ds.xml")
    public void createUser_newUser_shouldInsertUser() throws Exception {
        String userJson = "{\n"
                + "	\"username\": \"new.user\",\n"
                + "	\"firstName\": \"Jan\",\n"
                + "	\"lastName\" : \"Kowalski\",\n"
                + "	\"email\" : \"jan.kowalski@poczta.pl\",\n"
                + "	\"phone\" : \"888999000\"\n"
                + "}";

        ResultActions perform = mvc.perform(post("/users").content(userJson).contentType(MediaType.APPLICATION_JSON));

        perform.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.userId", notNullValue()));
    }

    @Test
    @DatabaseSetup("UserControllerIT.ds.populated.xml")
    public void createUser_existingUser_shouldReturBadRequest() throws Exception {
        String userJson = "{\n"
                + "	\"username\": \"user1\",\n"
                + "	\"firstName\": \"Jan\",\n"
                + "	\"lastName\" : \"Kowalski\",\n"
                + "	\"email\" : \"jan.kowalski@poczta.pl\",\n"
                + "	\"phone\" : \"888999000\"\n"
                + "}";

        ResultActions perform = mvc.perform(post("/users").content(userJson).contentType(MediaType.APPLICATION_JSON));

        perform.andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.code", is("USER_ALREADY_EXISTS")));
    }

}
