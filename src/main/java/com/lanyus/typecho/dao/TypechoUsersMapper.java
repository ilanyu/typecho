package com.lanyus.typecho.dao;

import com.lanyus.typecho.domain.TypechoUsers;

public interface TypechoUsersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_users
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_users
     *
     * @mbggenerated
     */
    int insert(TypechoUsers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_users
     *
     * @mbggenerated
     */
    int insertSelective(TypechoUsers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_users
     *
     * @mbggenerated
     */
    TypechoUsers selectByPrimaryKey(Integer uid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_users
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TypechoUsers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_users
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TypechoUsers record);
}