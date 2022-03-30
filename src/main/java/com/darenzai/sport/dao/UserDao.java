package com.darenzai.sport.dao;

import com.darenzai.sport.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
     public int getUserByMassage(@Param("username") String username, @Param("password") String password);
     public List<User> getAllUser(@Param("username") String userName,@Param("pageStart") int PageStart,@Param("pageSize") int PageSize);
     public int getUserCounts(@Param("username") String username);
     public int updateState(Integer id,Boolean state);
     public int addUser(User user);
     public User getUpdateUser(int id);
     public int editUser(User user);
     public int deleteUser(int id);

}
