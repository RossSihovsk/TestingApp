package com.lviv.task.dto;

import com.lviv.task.models.Article;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    public Integer id;
    public String name;
    public Integer age;
    public List<ArticleDTO> articleDTOS = new ArrayList<>();

    public UserDTO(Integer id, String name, Integer age, List<Article> article) {
        this.id = id;
        this.name = name;
        this.age = age;
        for (Article a: article){
               articleDTOS.add(new ArticleDTO(a.getText(),a.getColor()));
        }
    }
}
