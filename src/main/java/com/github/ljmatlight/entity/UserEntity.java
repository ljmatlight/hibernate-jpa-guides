package com.github.ljmatlight.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * 用户信息实体
 *
 * @author ljmatlight
 * @date 2018/6/5
 */
@ApiModel(value="UserEntity",description="用户信息实体")
@Entity
public class UserEntity implements Serializable {

    public UserEntity() {
    }

    /**
     * 用户ID
     */
    @Id
    @GeneratedValue
    @ApiModelProperty(hidden=true)
    private Integer uid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 前名
     */
    @ApiModelProperty(value="前名",required=true,example="Joke")
    private String firstName;

    @Override
    public String toString() {
        return "UserEntity{" + "uid=" + uid + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(getUid(), that.getUid()) && Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUid(), getFirstName(), getLastName());
    }

    /**
     * 后名
     */
    @ApiModelProperty(value="后名",required=true,example="Son")
    private String lastName;

    public UserEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
