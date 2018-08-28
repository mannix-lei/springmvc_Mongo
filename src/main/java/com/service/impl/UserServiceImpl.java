package com.service.impl;

import com.service.serviceInf.UserServiceInf;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.pojo.User;
import java.util.List;

/**
 * Created by Tellyes_worker on 2017/12/4/0004.
 */
@Repository
public class UserServiceImpl implements UserServiceInf {
    @Autowired
    private MongoTemplate mongoTemplate;
    public void delUser(String id){
        User user = findById(id);
        mongoTemplate.remove(user);
    }
    public void updateUser(User user) {
        mongoTemplate.save(user);
    }
    public void addUser(User user) {
        mongoTemplate.save(user);
    }
    public User findById(String id) {
        return mongoTemplate.findById(id,User.class);
    }
    public List<User> findByUserName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.find(query,User.class);
    }
    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }
    public String login(String id,String password) {
        User user = mongoTemplate.findById(id,User.class);
        if(user.getPassword().equals(password)){
            return  "登陆成功";
        }else {
            return "登陆失败";
        }
    }
    public void register(User user){
        mongoTemplate.insert(user);
    }

}
