package com.fastcampus.projectboard.controller;

import com.fastcampus.projectboard.config.SecurityConfig;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("View 컨트롤러 - 인증")
@Import(SecurityConfig.class)
@WebMvcTest
public class AuthControllerTest {


    private final MockMvc mvc;

    public AuthControllerTest(@Autowired MockMvc mvc) { // Test 부분은 @Autowired 를 붙여줘여함.
        this.mvc = mvc;
    }

    @DisplayName("[view][GET] - 로그인 페이지 - 정상호출")
    @Test
    public void givenNothing_whenTryingToLogin_thenReturnLogInView() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/login"))
                .andExpect(status().isOk()) // 200 OK
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
    }
}