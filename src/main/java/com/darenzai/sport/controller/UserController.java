package com.darenzai.sport.controller;


import com.alibaba.fastjson.JSON;
import com.darenzai.sport.bean.QueryInfo;
import com.darenzai.sport.bean.User;
import com.darenzai.sport.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.management.Query;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/allUser")
    public String getUserList(QueryInfo queryInfo){
        int ounts = userDao.getUserCounts("%" + queryInfo.getQuery() + "%");
        int pageStart=(queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<User> allUser = userDao.getAllUser("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",ounts);
        res.put("data",allUser);
        String res_String = JSON.toJSONString(res);
        return res_String;

    }
    @RequestMapping("/userState")
    public String updateUserState(@RequestParam("id") Integer id,@RequestParam("state") Boolean state){
        int i=userDao.updateState(id,state);
        return i>0?"success":"error";
    }
    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user){
        System.out.println(user);
        user.setRole("普通用户");
        user.setState(false);
        int i = userDao.mmit (user);
        String str = i >0?"success":"error";
        return str;
    }

    @RequestMapping("/getUpdate")
    public String getUpdateUser(int id){
        System.out.println("编号:"+id);
        User updateUser = userDao.getUpdateUser(id);
        String users_json = JSON.toJSONString(updateUser);
        return users_json;
    }

    @RequestMapping("/editUser")
    public String editUser(@RequestBody User user){
        System.out.println(user);
        int i = userDao.editUser(user);
        String str = i >0?"success":"error";
        return str;
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(int id){
        System.out.println(id);
        int i = userDao.deleteUser(id);
        String str = i >0?"success":"error";
        return str;
    }
}
