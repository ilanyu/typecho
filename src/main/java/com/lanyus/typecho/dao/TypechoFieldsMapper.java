package com.lanyus.typecho.dao;

import com.lanyus.typecho.domain.TypechoFields;
import com.lanyus.typecho.domain.TypechoFieldsKey;

public interface TypechoFieldsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_fields
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(TypechoFieldsKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_fields
     *
     * @mbggenerated
     */
    int insert(TypechoFields record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_fields
     *
     * @mbggenerated
     */
    int insertSelective(TypechoFields record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_fields
     *
     * @mbggenerated
     */
    TypechoFields selectByPrimaryKey(TypechoFieldsKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_fields
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TypechoFields record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_fields
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(TypechoFields record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_fields
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TypechoFields record);
}