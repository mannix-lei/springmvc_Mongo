package com.service.serviceInf;

import com.pojo.User;
import java.util.List;

/**
 * Created by Tellyes_worker on 2017/12/4/0004.
 */
public interface UserServiceInf {
     void addUser(User user);
     void delUser(String id);
     void updateUser(User user);
     User findById(String id);
     List<User> findByUserName(String name);
     List<User> findAll();
     String login(String id,String password);
     void register(User user);
}
