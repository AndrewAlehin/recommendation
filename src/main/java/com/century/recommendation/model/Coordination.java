package com.century.recommendation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "coordination")
public class Coordination extends AbstractBaseEntity {

    @Column(name = "test")
    private int test;
    @Column(name = "news")
    private int news;
    @Column(name = "articles")
    private int articles;

    @Column(name = "math")
    private int math;
    @Column(name = "russian")
    private int russian;
    @Column(name = "physics")
    private int physics;
    @Column(name = "history")
    private int history;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "coordination")
    private int coordination;

    private Coordination(int test, int news, int articles, int math, int russian, int physics, int history) {
        this.test = test;
        this.news = news;
        this.articles = articles;
        this.math = math;
        this.russian = russian;
        this.physics = physics;
        this.history = history;
        this.coordination = countCoordination(test, news, articles, math, russian, physics, history);
    }

    public Coordination() {
    }

    private int countCoordination(int test, int news, int articles, int math, int russian, int physics, int history) {
        return (int) Math.sqrt(Math.pow(test, 2) + Math.pow(news, 2) + Math.pow(articles, 2) + Math.pow(math, 2)
                + Math.pow(russian, 2) + Math.pow(physics, 2) + Math.pow(history, 2));
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    public int getNews() {
        return news;
    }

    public void setNews(int news) {
        this.news = news;
    }

    public int getArticles() {
        return articles;
    }

    public void setArticles(int articles) {
        this.articles = articles;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getRussian() {
        return russian;
    }

    public void setRussian(int russian) {
        this.russian = russian;
    }

    public int getPhysics() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public int getResult() {
        return coordination;
    }
}
