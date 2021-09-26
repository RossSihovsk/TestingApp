package com.lviv.task.service;

import com.lviv.task.dao.NamesOnly;
import com.lviv.task.dao.UserRepo;
import com.lviv.task.models.Article;
import com.lviv.task.models.Color;
import com.lviv.task.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> allAgeMoreThan(Integer age){

      return   userRepo.findAllByAgeIsAfter(age);
    }

   public boolean saveUser(User user){
        userRepo.save(user);
        return true;
    }

    public  List<NamesOnly> findDistinctNames(){
        return userRepo.findDistinctBy() ;
    }

    public User findById(Integer id){
        return userRepo.findUserById(id);
    }

    public  List<User> findArticlemore(Integer article){
        return  userRepo.findAllByArticlesIsAfter(article);
    }

    public List<User> findAll(){
        return userRepo.findAll();
    }

//    public List<User>test(){
//        return userRepo.findDistinct();
//    }

    @PostConstruct
    public void init() {

        User user = new User("Julia",26);
        user.addArticle(new Article(Color.WHITE,"Test text1"));
        user.addArticle(new Article(Color.WHITE,"Test text1"));
        saveUser(user);

        user = new User("Dima",12);
        user.addArticle(new Article(Color.WHITE,"Test text2"));
        user.addArticle(new Article(Color.BLACK,"Test text3"));
        saveUser(user);

        user = new User("Ostap",33);
        user.addArticle(new Article(Color.BLUE,"Test text4"));
        user.addArticle(new Article(Color.GREEN,"Test text5"));
        user.addArticle(new Article(Color.RED,"Test text6"));
        user.addArticle(new Article(Color.WHITE,"Test text1"));
        user.addArticle(new Article(Color.WHITE,"Test text1"));
        user.addArticle(new Article(Color.WHITE,"Test text1"));
        saveUser(user);

        user = new User("Dima",12);
        user.addArticle(new Article(Color.WHITE,"Test text7"));
        saveUser(user);

        user = new User("Ross",45);
        user.addArticle(new Article(Color.RED,"Test text8"));
        user.addArticle(new Article(Color.WHITE,"Test text9"));
        user.addArticle(new Article(Color.WHITE,"Test text1"));
        saveUser(user);

        user = new User("Alina",99);
        user.addArticle(new Article(Color.GREEN,"Test text10"));
        user.addArticle(new Article(Color.BLUE,"Test text11"));
        user.addArticle(new Article(Color.BLACK,"Test text12"));
        user.addArticle(new Article(Color.WHITE,"Test text1"));
        user.addArticle(new Article(Color.WHITE,"Test text1"));
        saveUser(user);

        user = new User("Julia",1);
        user.addArticle(new Article(Color.BLUE,"Test text1"));
        saveUser(user);

        user = new User("Sophie",15);
        user.addArticle(new Article(Color.BLACK,"Test text1"));
        user.addArticle(new Article(Color.GREEN,"Test text1"));
        user.addArticle(new Article(Color.WHITE,"Test text1"));
        saveUser(user);

        user = new User("Ross",76);
        user.addArticle(new Article(Color.RED,"Test text1"));
        user.addArticle(new Article(Color.WHITE,"Test text1"));
        user.addArticle(new Article(Color.GREEN,"Test text1"));
        user.addArticle(new Article(Color.WHITE,"Test text1"));
        saveUser(user);

    }

}
