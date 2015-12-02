package com.lanyus.typecho.dao;

import com.lanyus.typecho.domain.TypechoMetas;

public interface TypechoMetasMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_metas
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer mid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_metas
     *
     * @mbggenerated
     */
    int insert(TypechoMetas record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_metas
     *
     * @mbggenerated
     */
    int insertSelective(TypechoMetas record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_metas
     *
     * @mbggenerated
     */
    TypechoMetas selectByPrimaryKey(Integer mid);
    int selectMidBySlug(String slug);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_metas
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TypechoMetas record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_metas
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TypechoMetas record);
}