package com.example.Chapter4.repository;

import com.example.Chapter4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    @Procedure("delete_user")
    void deleteUser(@Param("user_name") String name);
}
