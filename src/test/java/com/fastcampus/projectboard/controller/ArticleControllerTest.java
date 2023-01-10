package com.fastcampus.projectboard.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
// TEST 실패하면 Gradle Build 가 실패가 됨, 실패하는 테스트를 올리지 않음.


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
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("articles/index")) // 뷰에 이름에 대한 테스트 -> 여기에 뷰가 있어야한다 테스트
                .andExpect(model().attributeExists("articles"));

    }

    @Disabled("구현중")
    @DisplayName("[view][GET] - 게시글 상세 (게시판) 페이지 - 정상호출")
    @Test
    public void givenNothing_whenRequestArticleView_thenReturnArticleView() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/articles/1"))
                .andExpect(status().isOk()) // 200 OK
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("articles/detail")) // 뷰에 이름에 대한 테스트 -> 여기에 뷰가 있어야한다 테스트
                .andExpect(model().attributeExists("article"))
                .andExpect(model().attributeExists("articleComments"));

    }

    @Disabled("구현중")
    @DisplayName("[view][GET] - 게시글 검섹 전용 (게시판) 페이지 - 정상호출")
    @Test
    public void givenNothing_whenRequestArticleSearchView_thenReturnArticleSearchView() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/articles/search"))
                .andExpect(status().isOk()) // 200 OK
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles/search"));

    }

    @Disabled("구현중")
    @DisplayName("[view][GET] - 게시글 해시태그 (게시판) 페이지 - 정상호출")
    @Test
    public void givenNothing_whenRequestArticleHashTagSearchView_thenReturnArticleHashTagSearchView() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk()) // 200 OK
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles/search-hashtag"));

    }
}