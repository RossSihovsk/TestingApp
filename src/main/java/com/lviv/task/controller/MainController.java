package com.lviv.task.controller;

import com.lviv.task.dao.NamesOnly;
import com.lviv.task.dao.UserIdOnly;
import com.lviv.task.models.Article;
import com.lviv.task.models.Color;
import com.lviv.task.models.User;
import com.lviv.task.service.ArticleService;
import com.lviv.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.*;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    ArticleService articleService;

    @GetMapping("/")
    public String hello(){
        return "index";
    }

    @PostMapping("/task1")
    public String  task1(@RequestParam Integer age){
        System.out.println("\nTask1 start");
       // System.out.println(age);
//        int age = Integer.parseInt(request.getParameter("age"));
        List<User> users = userService.allAgeMoreThan(age);

        for (User u: users){
            System.out.println(u.getId()+" "+u.getName()+" "+u.getAge());
        }
        System.out.println("\nTask1 end");
        return "redirect:/";
    }

    @PostMapping("/task2")
    public String findByColor(@RequestParam Color color){
        System.out.println("\nTask2 start");
        List<UserIdOnly> userIdOnly = articleService.findByColor(color);

        List<User> users = new ArrayList<>();
        for (UserIdOnly u: userIdOnly){
            users.add(userService.findById(u.getUserId()));
        }

        for (User u: users){
            System.out.println(u.getId()+" "+u.getName()+" "+u.getArticles());
        }
        System.out.println("\nTask2 end");
        return "redirect:/";
    }

    @PostMapping("/task3")
    String findDistinctNames1(@RequestParam(value = "articles") Integer articles ){
        System.out.println("\nTask3 start");
        Set<User> users = new HashSet<>(userService.findAll());

        users.removeIf(user -> user.getArticles().size() < articles+1);


        for (User u: users){
            System.out.println(u);
        }
        System.out.println("\nTask3 end");
        return "redirect:/";
    }

    @GetMapping("/task31")
    void findDistinctNames(){
        System.out.println("\nTask3.1 start");
        List<NamesOnly> users = userService.findDistinctNames();

        for (NamesOnly u: users){
            System.out.println(u.getName());
        }
        System.out.println("\nTask3.2 end");
    }


    @PostMapping("/task4")
    public String saveUser(@RequestParam String name,
                           @RequestParam Integer age,
                           @RequestParam String text,
                           @RequestParam Color color){
        User user = new User(name,age);
        user.addArticle(new Article(color,text));
        if (userService.saveUser(user)){

            System.out.println("User`s just been successfully saved");
        }
        else System.out.println("Unexpected thing happens :( ");

        return "redirect:/";
    }


}
