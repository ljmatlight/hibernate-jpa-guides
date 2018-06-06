package com.github.ljmatlight.repositories;

import com.github.ljmatlight.HibernateJpaGuidesApplication;
import com.github.ljmatlight.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 * 用户操作DAO单元测试
 *
 * @author ljmatlight
 * @date 2018/6/5
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateJpaGuidesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    public void sampleTestCase() throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        UserEntity dave = new UserEntity("Dave", "Matthews", 15, formatter.parse("2010-04-28"));
        dave = repository.save(dave);
        System.out.println("dave === " + dave);

        UserEntity carter = new UserEntity("Carter", "Beauford", 20, formatter.parse("2015-04-28"));
        carter = repository.save(carter);
        System.out.println("carter === " + carter);

        List<UserEntity> result = repository.findByLastName("Matthews");

        System.out.println("result.size() === " + result.size());
        System.out.println("result === " + result);
    }
}