package com.lviv.task.dao;

import com.lviv.task.dao.components.NamesOnly;
import com.lviv.task.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    List<User> findAllByAgeIsAfter(Integer age);

    User findUserById(Integer id);

    List<NamesOnly> findDistinctBy();

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String Email);

}
