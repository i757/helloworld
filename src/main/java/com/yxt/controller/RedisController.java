package com.yxt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/testredis",method = RequestMethod.GET)
    @ResponseBody
    public String testRedis(@RequestParam String value){
        stringRedisTemplate.opsForValue().set("name",value);
        String string = stringRedisTemplate.opsForValue().get("name");
        return string;
    }

}
