package com.fastcampus.projectboard.dto;


public record ArticleUpdateDTO(
        String title,
        String content,
        String hashtag
) {
    public static ArticleUpdateDTO of(String title, String content, String hashtag) {
        return new ArticleUpdateDTO(title, content, hashtag);
    }
}
