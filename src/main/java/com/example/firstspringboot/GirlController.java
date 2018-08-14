package com.example.firstspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;
    /**
     * 获取女生列表接口
     * @return
     */
    @GetMapping(value = "girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生接口
     * @param cupSize
     * @param age
     * @return
     */
    //接受键值对类型的POST请求
    @PostMapping(value = "girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age){
        Girl girl = new Girl(cupSize,age);
        return girlRepository.save(girl);
    }

    /**
     * 查询一个女生，这样写id没出现在url里面，例如girls/1
     * 注意get方法获取参数用@PathVariable注解从路径中获取参数，
     * 而不是RequestParam，下面同样。
     * @param id
     * @return
     */
    @GetMapping(value = "girls/{id}")
    public Girl getGirlById(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    //更新，注意更新时候在body中选择x-www-form-urlencoded格式
    @PutMapping(value = "girls/{id}")
    public Girl updateOneGirl(@PathVariable("id") Integer id,
                              @RequestParam("cupSize") String cupSize,
                              @RequestParam("age") Integer age){
        Girl girl = new Girl(cupSize,age);
        girl.setId(id);
        //会根据主键去存，有就覆盖
        return girlRepository.save(girl);
    }

    //删除
    @DeleteMapping(value = "girls/{id}")
    public void deleteOneGirl(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    //通过年龄查询,为了区分前面的，用girls/age/{age}
    @GetMapping(value = "girls/age/{age}")
    public List<Girl> findGirlsByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTow();
    }
}
