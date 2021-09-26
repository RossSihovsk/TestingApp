package com.lviv.task.models;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Article> articles =new ArrayList<>();

    public User(String name, Integer age, List<Article> articles) {
        this.name = name;
        this.age = age;
        this.articles = articles;
    }

    public User() {
    }


    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void  addArticle(Article article){
        articles.add(article);
        article.setUser(this);
    }


    @Override
    public boolean equals(Object o) {
        User user = (User) o;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {

        return name.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", articles=" + articles +
                '}';
    }


}
