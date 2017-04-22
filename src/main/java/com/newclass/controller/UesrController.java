package com.newclass.controller;

import com.newclass.bean.UserEntity;
import com.newclass.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by liujiawang on 2017/4/15.
 */
@Controller
@RequestMapping("/user")
public class UesrController {

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password){

        UserEntity user = userDao.getByUserName(username);

        if(password.equals(user.getPassword())){
            return "index";
        }else{
            return "login";
        }
    }

    @RequestMapping(value ="/register", method = RequestMethod.POST)
    public String register(String username, String password1){

        userDao.insertUser(username,password1);
        return "index";
    }


}
