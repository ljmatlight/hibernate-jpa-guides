package com.github.ljmatlight.repositories;

import com.github.ljmatlight.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 用户操作dao
 *
 * @author ljmatlight
 * @date 2018/6/5
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    List<UserEntity> findByLastName(String lastName);

}
