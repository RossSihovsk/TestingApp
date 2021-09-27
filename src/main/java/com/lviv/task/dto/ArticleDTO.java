package com.lviv.task.dto;

import com.lviv.task.models.Color;

public class ArticleDTO {

    public  String text;
    public Color color;

    public ArticleDTO(String text, Color color) {
        this.text = text;
        this.color = color;
    }
}
