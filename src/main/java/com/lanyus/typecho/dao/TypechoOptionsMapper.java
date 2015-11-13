package com.lanyus.typecho.dao;

import com.lanyus.typecho.domain.TypechoOptions;
import com.lanyus.typecho.domain.TypechoOptionsKey;

public interface TypechoOptionsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_options
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(TypechoOptionsKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_options
     *
     * @mbggenerated
     */
    int insert(TypechoOptions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_options
     *
     * @mbggenerated
     */
    int insertSelective(TypechoOptions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_options
     *
     * @mbggenerated
     */
    TypechoOptions selectByPrimaryKey(TypechoOptionsKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_options
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TypechoOptions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_options
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(TypechoOptions record);
}