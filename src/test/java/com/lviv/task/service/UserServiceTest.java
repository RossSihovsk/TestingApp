package com.lviv.task.service;

import com.lviv.task.dao.UserRepo;
import com.lviv.task.models.User;

import org.junit.jupiter.api.Test;

import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;

import java.util.List;

import static org.mockito.BDDMockito.*;

@SpringBootTest
class UserServiceTest {

    @Mock
    private UserRepo repository;

    @InjectMocks
    private UserService service;

    @Test
    void findAll() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "test", 25,"test1"));
        users.add(new User(2, "test", 25,"test2"));
        users.add(new User(3, "test", 25,"test3"));
        users.add(new User(4, "test", 25,"test4"));
        users.add(new User(5, "test", 25,"test5"));
        when(repository.findAll()).thenReturn(users);

        List<User> expected = service.findAll();
        System.out.println(expected);
        assertEquals(expected,users);
    }

//    @BeforeEach
//    void initUseCase() {
//        service.saveUser(new User(1, "test", 25,"test"));
//    }

//    @Test
//    void existsByEmail() {
//        Boolean isExist;
//        User user = new User("24",24,"test","2222");
//        given(repository.existsByEmail("test")).willAnswer(InvocationOnMock::getArguments);
//
//        Assertions.assertTrue(service.existsByEmail("test"), "email not found");
//
//    }
//
//    @Test
//    void saveUser() {
//        User user = new User(1, "test321", 25,"test");
//        given(repository.save(user)).willAnswer(InvocationOnMock::getArguments);
//
//        Assertions.assertTrue(service.saveUser(user), "User Not saved");
//    }

//    @Test
//    void FindById() {
//        Integer id = 1;
//        User user = new User(id, "test321", 25,"test");
//        repository.save(user);
//        user.setPassword("testPass");
//        given(repository.findById(id)).willReturn(Optional.of(user));
//
//        Optional<User> expected = Optional.ofNullable(service.findById(1));
//        System.out.println(expected);
//
//        Assertions.assertTrue(expected.isPresent(), "User Not found");
//    }


}