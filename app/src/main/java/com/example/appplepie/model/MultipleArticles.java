package com.example.appplepie.model;

import com.example.appplepie.model.Article;

import java.util.List;

public class MultipleArticles {
    List<Article> articles;
    int articlesCount;

    public MultipleArticles(List<Article> articles, int articlesCount) {
        this.articles = articles;
        this.articlesCount = articlesCount;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public int getArticlesCount() {
        return articlesCount;
    }

    public void setArticlesCount(int articlesCount) {
        this.articlesCount = articlesCount;
    }
}
