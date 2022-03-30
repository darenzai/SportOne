package com.darenzai.sport.controller;


import com.alibaba.fastjson.JSON;
import com.darenzai.sport.bean.MainMenu;
import com.darenzai.sport.dao.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class MenuController {

    @Autowired
    MenuDao menuDao;

    @RequestMapping("/menus")
    public String getAllmenus(){
        HashMap<String,Object> data=new HashMap<>();
        int status=404;

        List<MainMenu> menus = menuDao.getMainMenus();
        if(menus!=null){
            data.put("menus",menus);
            data.put("flag",200);

        }else {
            data.put("flag",404);
        }
        String s= JSON.toJSONString(data);
        return s;
    }
}
