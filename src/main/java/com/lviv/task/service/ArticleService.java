package com.lviv.task.service;

import com.lviv.task.dao.ArticleRepo;
import com.lviv.task.dao.components.UserIdOnly;
import com.lviv.task.models.Article;
import com.lviv.task.models.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepo articleRepo;

    public void  saveArticle(Article article){
        articleRepo.save(article);
    }

    public List<UserIdOnly> findByColor(Color color){
        return articleRepo.findAllByColor(color);
    }
}
