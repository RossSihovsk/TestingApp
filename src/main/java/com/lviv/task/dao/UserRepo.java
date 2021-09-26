package com.lviv.task.dao;

import com.lviv.task.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    List<User> findAllByAgeIsAfter(Integer age);

    User findUserById(Integer id);
    List<NamesOnly> findDistinctBy();

    List<User> findAllByArticlesIsAfter(Integer article);


    User findByName(String name);
}
