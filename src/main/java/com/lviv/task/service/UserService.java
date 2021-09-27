package com.lviv.task.service;

import com.lviv.task.dao.components.NamesOnly;
import com.lviv.task.dao.UserRepo;
import com.lviv.task.dao.components.UserIdOnly;
import com.lviv.task.dto.UserDTO;
import com.lviv.task.models.Article;
import com.lviv.task.models.Color;
import com.lviv.task.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    ArticleService articleService;

    public List<User> allAgeMoreThan(Integer age){

        return   userRepo.findAllByAgeIsAfter(age);
    }

    Optional<User> findByEmail(String Email){
        return userRepo.findByEmail(Email);
    }

    public boolean existsByEmail(String email){
        return userRepo.existsByEmail(email);
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

    public List<User> findAll(){
        return userRepo.findAll();
    }



    public List<UserDTO> task1(Integer age){
        System.out.println("\nTask1 start");

        List<User> users = userRepo.findAllByAgeIsAfter(age);
        List<UserDTO>userDTOS = new ArrayList<>();

        for (User u: users){
            userDTOS.add(new UserDTO(u.getId(),u.getName(),u.getAge(),u.getArticles()));
        }
        return userDTOS;
    }


    public List<UserDTO> task2( Color color){
        System.out.println("\nTask2 start");
        StringBuffer stringBuffer = new StringBuffer();

        List<UserIdOnly> userIdOnly = articleService.findByColor(color);

        Set<User> users = new HashSet<>();
        for (UserIdOnly u: userIdOnly){
            users.add(findById(u.getUserId()));
        }
        List<UserDTO>userDTOS = new ArrayList<>();
        for (User u: users){

            userDTOS.add(new UserDTO(u.getId(),u.getName(),u.getAge(),u.getArticles()));
        }
        System.out.println("\nTask2 end");
        return userDTOS;
    }


    public List<UserDTO> task3(Integer articles ){
        System.out.println("\nTask3 start");
        Set<User> users = new HashSet<>(findAll());

        users.removeIf(user -> user.getArticles().size() < articles+1);

        List<UserDTO>userDTOS = new ArrayList<>();
        for (User u: users){
            userDTOS.add(new UserDTO(u.getId(),u.getName(),u.getAge(),u.getArticles()));
        }
        System.out.println("\nTask3 end");
        return userDTOS;
    }


    public String task4(String name, Integer age, String text, Color color){
        System.out.println("\nTask4 start");
        User user = new User(name,age);
        user.addArticle(new Article(color,text));
        if (saveUser(user)){
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
