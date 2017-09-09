package com.example.simples.sm.entity.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_user
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
@Table(name = "t_user")
public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.id
     *
     * @mbg.generated
     */
    @Id
    private Integer id;

    /**
     * Database Column Remarks:
     * 用户名
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.username
     *
     * @mbg.generated
     */
    private String username;

    /**
     * Database Column Remarks:
     * 用户密码
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.password
     *
     * @mbg.generated
     */
    private String password;

}