package com.lviv.task.models;

import javax.persistence.*;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column
    private Color color;

    @Column
    private String text;

    public Article(User user, Color color, String text) {
        this.user = user;
        this.color = color;
        this.text = text;
    }

    public Article(Color color, String text) {
        this.color = color;
        this.text = text;
    }

    public Article() {

    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Color getColor() {
        return color;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Article: "+
             "Color -> "+color+ "; Text -> "+text;
    }
}
