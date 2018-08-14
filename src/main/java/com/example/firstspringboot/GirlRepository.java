package com.example.firstspringboot;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Jpa很好用，减少书写sql语句，简单就能操作数据库
public interface GirlRepository extends JpaRepository<Girl, Integer>{

    //通过年龄查询，必须按照findByXXX格式书写，就能通过某一字段查询
    List<Girl> findByAge(Integer age);

}
