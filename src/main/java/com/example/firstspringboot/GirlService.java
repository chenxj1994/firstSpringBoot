package com.example.firstspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//当你需要定义某个类为一个bean，（功能类的bean）
// 则在这个类的类名前一行使用@Service,定义成bean后，则可用autowired注解了
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;
    //Transactional用于数据库事务的操作，
    // 例如要么同时执行，要么同时不执行，适用于增删改操作，查询可以不需要
    @Transactional
    public void insertTow(){
        Girl girlA = new Girl("A",12);
        girlRepository.save(girlA);

        Girl girlB = new Girl("DDD",28);
        girlRepository.save(girlB);

    }

}
