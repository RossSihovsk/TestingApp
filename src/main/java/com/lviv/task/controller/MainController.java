package com.lviv.task.controller;

import com.lviv.task.dao.components.NamesOnly;
import com.lviv.task.dao.components.UserIdOnly;
import com.lviv.task.models.Article;
import com.lviv.task.models.Color;
import com.lviv.task.models.User;
import com.lviv.task.service.ArticleService;
import com.lviv.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/main")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    ArticleService articleService;

    @GetMapping("/")
    public String hello(){
        return "index";
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/task1")
    public  StringBuffer task1(@RequestParam Integer age){
        System.out.println("\nTask1 start");

        List<User> users = userService.allAgeMoreThan(age);

        StringBuffer stringBuffer = new StringBuffer();

        for (User u: users){
            stringBuffer.append(u.getName()+" "+u.getAge()+"\n");
            System.out.println(u.getName()+" "+u.getAge());
        }
        System.out.println("\nTask1 end");
        return stringBuffer;
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/task2")
    public StringBuffer findByColor(@RequestParam Color color){
        System.out.println("\nTask2 start");
        StringBuffer stringBuffer = new StringBuffer();
        List<UserIdOnly> userIdOnly = articleService.findByColor(color);

        List<User> users = new ArrayList<>();
        for (UserIdOnly u: userIdOnly){
            users.add(userService.findById(u.getUserId()));
        }

        for (User u: users){
            stringBuffer.append(u.getName()+" "+u.getArticles()+"\n");
            System.out.println(u.getName()+" "+u.getArticles());
        }
        System.out.println("\nTask2 end");
        return stringBuffer;
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/task3")
    StringBuffer findDistinctNames1(@RequestParam(value = "articles") Integer articles ){
        System.out.println("\nTask3 start");
        Set<User> users = new HashSet<>(userService.findAll());

        users.removeIf(user -> user.getArticles().size() < articles+1);

        StringBuffer stringBuffer = new StringBuffer();
        for (User u: users){
            stringBuffer.append(u.getName()+" "+u.getArticles()+"\n");
            System.out.println(u.getName()+" "+u.getArticles());
        }
        System.out.println("\nTask3 end");
        return stringBuffer;
    }

//    @GetMapping("/task31")
//    void findDistinctNames(){
//        System.out.println("\nTask3.1 start");
//        List<NamesOnly> users = userService.findDistinctNames();
//
//        for (NamesOnly u: users){
//            System.out.println(u.getName());
//        }
//        System.out.println("\nTask3.2 end");
//    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/task4")
    public String saveUser(@RequestParam String name,
                           @RequestParam Integer age,
                           @RequestParam String text,
                           @RequestParam Color color){
        System.out.println("\nTask4 start");
        User user = new User(name,age);
        user.addArticle(new Article(color,text));
        if (userService.saveUser(user)){
            System.out.println("User`s just been successfully saved");
            System.out.println("\nTask4 end");
            return"User`s just been successfully saved";
        }

        else {
            System.out.println("Unexpected thing happens :( ");
            System.out.println("\nTask4 end");
            return "Unexpected thing happens :( ";
        }
    }


    @GetMapping("/all")
    public String allAccess() {
        return "public API";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "user API";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public String moderatorAccess() {
        return "moderator API";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "admin API";
    }


}
