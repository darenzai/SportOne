package com.darenzai.sport.dao;

import com.darenzai.sport.bean.MainMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {

    public List<MainMenu> getMainMenus();
}
