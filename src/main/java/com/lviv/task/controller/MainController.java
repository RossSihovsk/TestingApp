package com.lviv.task.controller;

import com.lviv.task.dao.components.UserIdOnly;
import com.lviv.task.dto.UserDTO;
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

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/task1")
    public  List<UserDTO> task1(@RequestParam Integer age){

        return userService.task1(age);
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/task2")
    public List<UserDTO> task2(@RequestParam Color color){

        return userService.task2(color);
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/task3")
    List<UserDTO> task3(@RequestParam(value = "articles") Integer articles ){
        return userService.task3(articles);
    }


    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/task4")
    public String task4(@RequestParam String name,
                        @RequestParam Integer age,
                        @RequestParam String text,
                        @RequestParam Color color){

        return  userService.task4(name,age,text,color);
    }


    @GetMapping("/all")
    public String allAccess() {
        return "all access with no authentication";
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
