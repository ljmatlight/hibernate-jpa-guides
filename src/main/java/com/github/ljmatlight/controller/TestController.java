package com.github.ljmatlight.controller;

import com.github.ljmatlight.entity.UserEntity;
import com.github.ljmatlight.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试接口
 *
 * @author ljmatlight
 * @date 2018/6/5
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    UserRepository repository;

    @GetMapping("/jpa")
    public List<UserEntity> testJpa() {

        UserEntity dave = new UserEntity("Dave", "Matthews");
        dave = repository.save(dave);
        System.out.println("dave === " + dave);

        UserEntity carter = new UserEntity("Carter", "Beauford");
        carter = repository.save(carter);
        System.out.println("carter === " + carter);

        List<UserEntity> result = repository.findByLastName("Matthews");

        System.out.println("result.size() === " + result.size());
        System.out.println("result === " + result);

        return result;
    }


}
