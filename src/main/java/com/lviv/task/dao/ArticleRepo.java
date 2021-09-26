package com.lviv.task.dao;

import com.lviv.task.dao.components.UserIdOnly;
import com.lviv.task.models.Article;
import com.lviv.task.models.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepo extends JpaRepository<Article, Integer> {

    List<UserIdOnly> findAllByColor(Color color);

}
