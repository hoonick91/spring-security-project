package me.hoonick.springsecurityproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class)
public class LoginControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void givenRequestOnPublicPage_shouldReturn200() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void givenRequestOnPrivateAndAdminPageWithoutLogin_shouldReturn401() throws Exception {
        mvc.perform(get("/private"))
                .andExpect(status().isUnauthorized());

        mvc.perform(get("/admin"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(value = "fake-user")
    public void givenRequestOnPrivatePageWithCredential_shouldReturn200() throws Exception {
        mvc.perform(
                get("/private")
        ).andExpect(
                status().isOk()
        );
    }

    @Test
    @WithMockUser(value = "fake-user")
    public void givenRequestOnAdminPageWithCredential_shouldReturn403() throws Exception {
        mvc.perform(
                get("/admin")
        ).andExpect(
                status().isForbidden()
        );
    }

    @Test
    @WithMockUser(value="fake-user", roles = "ADMIN")
    public void givenRequestOnAdminPageWithAdminRole_shouldReturn200() throws Exception {
        mvc.perform(
                get("/admin")
        ).andExpect(
                status().isOk()
        );
    }



}