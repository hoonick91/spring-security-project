package me.hoonick.springsecurityproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebSecurityIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void givenRequestOnPrivatePageWithRealCredential_shouldReturn200() throws Exception {
        mvc.perform(
                get("/private")
                        .with(httpBasic("user", "wrong-password"))
        ).andExpect(
                status().isUnauthorized()
        );

        mvc.perform(
                get("/private")
                        .with(httpBasic("admin", "password"))
        ).andExpect(
                status().isOk()
        );

        mvc.perform(
                get("/private")
                        .with(httpBasic("user", "password"))
        ).andExpect(
                status().isOk()
        );
    }
}


