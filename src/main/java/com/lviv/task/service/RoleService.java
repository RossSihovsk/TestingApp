package com.lviv.task.service;

import com.lviv.task.dao.RoleRepo;
import com.lviv.task.models.ERole;
import com.lviv.task.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    RoleRepo roleRepo;

    public Optional<Role> findByName(ERole name){
        return roleRepo.findByName(name);
    }

    @PostConstruct
    public void init() {
        roleRepo.save(new Role(ERole.ROLE_ADMIN));
        roleRepo.save(new Role(ERole.ROLE_USER));
        roleRepo.save(new Role(ERole.ROLE_MODERATOR));
    }
}
