package com.github.ljmatlight.repositories;

import com.github.ljmatlight.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 用户操作dao
 *
 * @author ljmatlight
 * @date 2018/6/5
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    /**
     * 通过后名查询用户信息
     *
     * @param lastName 后名
     * @return 符合条件的用户信息列表
     */
    List<UserEntity> findByLastName(String lastName);

    /**
     * 通过前名和后名查询用户信息
     *
     * @param firstName 前名
     * @param lastName  后名
     * @return 符合条件的用户信息列表
     */
    List<UserEntity> findByFirstNameAndLastName(String firstName, String lastName);

    /**
     * 通过前名和后名查询用户信息，并将信息按 uid 倒序排列
     *
     * @param firstName 前名
     * @param lastName  后名
     * @return 符合条件的用户信息列表
     */
    List<UserEntity> findByFirstNameAndLastNameOrderByUidDesc(String firstName, String lastName);

    /**
     * 查询前1条数据记录
     *
     * @param lastName 后名
     * @return 符合条件的用户信息列表
     */
    List<UserEntity> findFirst1ByLastName(String lastName);

    /**
     * 通过后名查询前10条用户信息记录
     *
     * @param lastName 后名
     * @return 符合条件的用户信息列表
     */
    List<UserEntity> findTop10ByLastName(String lastName);

    /**
     * 通过后名查询前10条用户信息记录
     *
     * @param lastName 后名
     * @return 符合条件的用户信息列表
     */
    @Query(value = "select u.uid, u.age, u.birthday, u.firstName, u.lastName " +
            " from userentity u where u.lastName = :lastName limit 1 ", nativeQuery = true)
    List<UserEntity> findDataByLastName(@Param("lastName") String lastName);


}
