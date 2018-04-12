package com.yxt.jpa.service;

import com.yxt.jpa.entity.User;
import com.yxt.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByName(String name){
        return userRepository.findByName(name);
    }

    public User findUser(String name){
        return userRepository.findUser(name);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public void saveList(List<User> list){
        userRepository.save(list);
    }

    public void transactional(User user1,User user2){
        userRepository.save(user1);
        userRepository.save(user2);
    }

}
