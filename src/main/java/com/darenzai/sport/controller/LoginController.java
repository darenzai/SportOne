package com.darenzai.sport.controller;
import com.alibaba.fastjson.JSON;
import com.darenzai.sport.bean.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.darenzai.sport.dao.UserDao;

import java.util.HashMap;

@RestController
public class LoginController {


    @Autowired
    UserDao userDao;


    @CrossOrigin
    @RequestMapping("/login")
    public String userLogin(@RequestBody User user) {
        System.out.println("User : " + user);
        String str = "error";
        int count = userDao.getUserByMassage(user.getUsername(), user.getPassword());
        if (count > 0) {
            str = "ok";
        }
        HashMap<String,Object> res=new HashMap<>();
        res.put("flag","ok");
        res.put("user",user);
        String res_json= JSON.toJSONString(res);
        return res_json;
    }


}
