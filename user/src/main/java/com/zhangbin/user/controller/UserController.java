package com.zhangbin.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhangbin.common.ResponseFactory;
import com.zhangbin.user.entity.User;
import com.zhangbin.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    /**
     * 登录
     * @param object
     * @return
     */
    @PostMapping("/user/login")
    public Object findUserByUserNameAndPassWord(@RequestBody JSONObject object){
        User user = userRepository.findUserByUserNameAndPassWord(object.getString("username"), object.getString("password"));
        if (user!=null){
            return ResponseFactory.instance(true,user,"登录成功");
        }else{
            return ResponseFactory.instance(false,user,"用户或密码错误");
        }
    }


    /**
     * 注册
     * @param object
     * @return
     */
    @PostMapping("/user/register")
    public Object registerUser(@RequestBody JSONObject object){
        String username = object.getString("username");
        String password = object.getString("password");
        if(userRepository.existsUserByUserName(username)){
            return ResponseFactory.instance(false,"","用户已存在");
        }

        User registerUser =new User();
        registerUser.setUserName(username);
        registerUser.setPassWord(password);
        registerUser.setDisabled(0);

        return ResponseFactory.instance(true , userRepository.save(registerUser) ,"注册成功");
    }


    /* ******************************************************
     *   用户CRUD
     * ******************************************************/

    /**
     * 查询全部用户
     * @return
     */
    @GetMapping("/user/findAll")
    public Object findAll(){
        Map<Object,Object> map = new HashMap<>();
        List<User> users = userRepository.findAll();
        map.put("users",users);
        map.put("total",users.size());
        return ResponseFactory.instance(true,map,"");
    }

    /**
     * 根据 ID 查询用户
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public Object getUser(@PathVariable("id") Long id){
        if(userRepository.existsById(id)){
            return ResponseFactory.instance(true,userRepository.getOne(id),"");
        }else {
            return ResponseFactory.instance(false,"","用户不存在");
        }
    }

    /**
     * 根据 username 模糊查询
     * @param name
     * @return
     */
    @GetMapping("/user/findByName/{name}")
    public Object findByName(@PathVariable("name") String name){
        Map<Object,Object> map = new HashMap<>();
        List<User> users = userRepository.findByUserNameLike("%" + name + "%");
        map.put("users",users);
        map.put("total",users.size());
        return ResponseFactory.instance(true,map,"") ;
    }

    /**
     * 统计用户数量
     * @return
     */
    @GetMapping("/user/userCounter")
    public Object userCounter(){
        return ResponseFactory.instance(true,userRepository.count(),"");
    }


}
