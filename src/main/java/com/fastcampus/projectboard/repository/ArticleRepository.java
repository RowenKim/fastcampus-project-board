package com.fastcampus.projectboard.repository;

import com.fastcampus.projectboard.domain.Article;
import com.fastcampus.projectboard.domain.QArticle;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleRepository extends
        JpaRepository<Article, Long>,
        QuerydslPredicateExecutor<Article>, // 기본 검색 기능
        QuerydslBinderCustomizer<QArticle> {
    @Override
    default void customize(QuerydslBindings bindings, QArticle root){
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.title, root.content, root.hashTag, root.createdAt, root.createdBy); // 필터 검색할 컬럼
//        bindings.bind(root.content).first(StringExpression::likeIgnoreCase); // LIKE '%{V}'
        bindings.bind(root.title).first(StringExpression::containsIgnoreCase); // LIKE '%{v}%'
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase); // LIKE '%{v}%'
        bindings.bind(root.hashTag).first(StringExpression::containsIgnoreCase); // LIKE '%{v}%'
        bindings.bind(root.createdAt).first(DateTimeExpression::eq); // LIKE '%{v}%'
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase); // LIKE '%{v}%'
    };
}
