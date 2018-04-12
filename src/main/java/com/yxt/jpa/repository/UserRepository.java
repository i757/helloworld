package com.yxt.jpa.repository;

import com.yxt.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,String> {
    User findByName(String name);

    @Query(value = "select * from user where name = ?1",nativeQuery = true)
    User findUser(String name);
}
