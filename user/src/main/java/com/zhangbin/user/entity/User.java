package com.zhangbin.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

//使用JPA注解配置映射关系
@Entity//告诉JPA这是一个实体类(和数据表映射的类)
@Table(name="user")//@Table来指定和哪个数据表对应;如果省略默认表名就是user;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id  //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //自增主键
    private Long id;

    @Column(name = "username",length = 50) //这是和数据表对应的一个列
    private String userName;
    @Column(name = "password",length = 50)
    private String passWord;
    @Column(name = "disabled")
    private Integer disabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }
}
