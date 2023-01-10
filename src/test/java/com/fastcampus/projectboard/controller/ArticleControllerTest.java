package com.fastcampus.projectboard.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("View 컨트롤러 - 게시글")
@WebMvcTest(ArticleController.class) // @WebMvcTest 만 적으면 모든 컨트롤러를 읽어드림, class 를 잡아줌.
class ArticleControllerTest {

    private final MockMvc mvc;

    public ArticleControllerTest(@Autowired MockMvc mvc) { // Test 부분은 @Autowired 를 붙여줘여함.
        this.mvc = mvc;
    }

    @DisplayName("[view][GET] - 게시글 리스트 (게시판) 페이지 - 정상호출")
    @Test
    public void givenNothing_whenRequestArticlesView_thenReturnArticlesView() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/articles"))
                .andExpect(status().isOk()) // 200 OK
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles"));

    }

    @DisplayName("[view][GET] - 게시글 상세 (게시판) 페이지 - 정상호출")
    @Test
    public void givenNothing_whenRequestArticleView_thenReturnArticleView() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/articles/1"))
                .andExpect(status().isOk()) // 200 OK
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("article"));

    }

    @DisplayName("[view][GET] - 게시글 검섹 전용 (게시판) 페이지 - 정상호출")
    @Test
    public void givenNothing_whenRequestArticleSearchView_thenReturnArticleSearchView() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/articles/search"))
                .andExpect(status().isOk()) // 200 OK
                .andExpect(content().contentType(MediaType.TEXT_HTML));

    }

    @DisplayName("[view][GET] - 게시글 해시태그 (게시판) 페이지 - 정상호출")
    @Test
    public void givenNothing_whenRequestArticleHashTagSearchView_thenReturnArticleHashTagSearchView() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk()) // 200 OK
                .andExpect(content().contentType(MediaType.TEXT_HTML));

    }
}