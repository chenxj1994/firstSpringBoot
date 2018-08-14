package com.example.firstspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//该项目中HelloController和GirlProperties为示例，与项目不关联
//加了这个注解外部才能访问
@RestController
//给整个类设置url
@RequestMapping(value = "/hello")
class HelloController {

    @Autowired
    private GirlProperties girlProperties;
    //默认情况下get和post都可以
    //pathVariable注解用于获取参数中的数据
//    @RequestMapping(value = {"/say"}, method = RequestMethod.GET)
    //组合注解,等同于上面那个
    @GetMapping(value = "/say")
    //required表示是否必传，0表示默认值
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0")Integer id){
        return "id:"+ id;
    }
}
