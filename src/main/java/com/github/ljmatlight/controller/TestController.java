package com.github.ljmatlight.controller;

import com.github.ljmatlight.entity.UserEntity;
import com.github.ljmatlight.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试接口
 *
 * @author ljmatlight
 * @date 2018/6/5
 */
@Slf4j
@RestController
@RequestMapping("/test/jpa")
public class TestController {

    @Autowired
    UserRepository repository;

    @GetMapping("/test")
    public List<UserEntity> testJpa() throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        UserEntity dave = new UserEntity("Dave", "Matthews", 15, formatter.parse("2010-05-28"));
        dave = repository.save(dave);
        log.info("dave === " + dave);

        UserEntity carter = new UserEntity("Carter", "Beauford", 20, formatter.parse("2015-05-28"));
        carter = repository.save(carter);
        log.info("carter === " + carter);

        List<UserEntity> result = repository.findByLastName("Matthews");

        log.info("result.size() === " + result.size());
        log.info("result === " + result);

        return result;
    }

    @GetMapping("/findByFirstNameAndLastName")
    public List<UserEntity> findByFirstNameAndLastName() {

        List<UserEntity> result = repository.findByFirstNameAndLastName("Carter", "Beauford");
        log.info("result === " + result);

        return result;
    }

    @GetMapping("/findByFirstNameAndLastNameOrderByUidDesc")
    public List<UserEntity> findByFirstNameAndLastNameOrderByUidDesc() {

        List<UserEntity> result = repository.findByFirstNameAndLastNameOrderByUidDesc("Carter", "Beauford");
        log.info("result === " + result);

        return result;
    }

    @GetMapping("/testJpaInnerMethods")
    public List<UserEntity> testJpaInnerMethods() {

        List<UserEntity> result = repository.findAll();
        log.info("findAll === " + result);

        UserEntity userEntity = repository.findOne(1);
        log.info("findOne === " + userEntity);

        long count = repository.count();
        log.info("count === " + count);

        boolean existsId = repository.exists(2);
        log.info("existsId === " + existsId);
        if (existsId) {
            log.info("删除UID为" + 2 + "用户");
            repository.delete(2);
        }

        List<Integer> ids = new ArrayList<>();
        ids.add(3);
        ids.add(4);
        ids.add(5);

        result = repository.findAll(ids);
        log.info("findAll(ids) === " + result);

        return result;
    }

    @GetMapping("/findFirst1ByLastName")
    public List<UserEntity> findFirst1ByLastName() {

        List<UserEntity> result = repository.findFirst1ByLastName("Beauford");
        log.info("result === " + result);

        return result;
    }

    @GetMapping("/findTop10ByLastName")
    public List<UserEntity> findTop10ByLastName() {

        List<UserEntity> result = repository.findTop10ByLastName("Beauford");
        log.info("result === " + result);

        return result;
    }

    @GetMapping("/findDataByLastName")
    public List<UserEntity> findDataByLastName() {

        List<UserEntity> result = repository.findDataByLastName("Beauford");
        log.info("result === " + result);

        return result;
    }

}
