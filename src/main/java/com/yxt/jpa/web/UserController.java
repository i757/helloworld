package com.yxt.jpa.web;

import com.yxt.jpa.entity.User;
import com.yxt.jpa.entity.pojo.UserCreate;
import com.yxt.jpa.service.UserService;
import com.yxt.util.ApiException;
import com.yxt.util.ApiUtils;
import com.yxt.util.KeyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "saveuser",method = RequestMethod.POST)
    public User save(@Validated @RequestBody UserCreate bean){
        User user = new User();
        user.setId(ApiUtils.getUUID());
        user.setName(bean.getName());
        user.setAge(bean.getAge());
        return userService.save(user);
    }
    @RequestMapping(value = "transactional",method = RequestMethod.GET)
    public void testTransactional(){
        User u1 = new User("a","a",1);
        User u2 = new User("c","b",1);
        userService.transactional(u1,u2);
    }

    @RequestMapping(value = "findbyname",method = RequestMethod.GET)
    public User findByName(@RequestParam String name){

        if(1 == 1){
            throw new ApiException(KeyConstants.USER_NAME_NOT_NULL);
        }
        return userService.findByName(name);
    }

    @RequestMapping(value = "finduser",method = RequestMethod.GET)
    public User findUser(@RequestParam String name){
        return userService.findUser(name);
    }
}
