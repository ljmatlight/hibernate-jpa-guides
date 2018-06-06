package com.github.ljmatlight.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息实体
 *
 * @author ljmatlight
 * @date 2018/6/5
 */
@Data
@AllArgsConstructor
@ApiModel(value = "UserEntity", description = "用户信息实体")
@Entity
public class UserEntity implements Serializable {

    /**
     * 用户ID
     */
    @Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Integer uid;

    /**
     * 前名
     */
    @ApiModelProperty(value = "前名", required = true, example = "Joke")
    private String firstName;

    /**
     * 后名
     */
    @ApiModelProperty(value = "后名", required = true, example = "Son")
    private String lastName;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄", required = true, example = "28")
    private Integer age;

    /**
     * 生日
     */
    @ApiModelProperty(value = "生日", required = true, example = "2018-06-01")
    private Date birthday;

    public UserEntity(String firstName, String lastName, Integer age, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthday = birthday;
    }
}
