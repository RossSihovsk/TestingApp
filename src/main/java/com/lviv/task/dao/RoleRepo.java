package com.lviv.task.dao;

import com.lviv.task.models.ERole;
import com.lviv.task.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo  extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
