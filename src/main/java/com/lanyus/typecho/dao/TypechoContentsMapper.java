package com.lanyus.typecho.dao;

import com.lanyus.typecho.domain.TypechoContents;

import java.util.List;

public interface TypechoContentsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_contents
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer cid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_contents
     *
     * @mbggenerated
     */
    int insert(TypechoContents record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_contents
     *
     * @mbggenerated
     */
    int insertSelective(TypechoContents record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_contents
     *
     * @mbggenerated
     */
    TypechoContents selectByPrimaryKey(Integer cid);
    List<TypechoContents> selectAll();
    List<TypechoContents> selectAllOrderBy();
    List<TypechoContents> selectAllByLimit(Integer start, Integer limit);
    List<TypechoContents> selectLike(String wd);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_contents
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TypechoContents record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_contents
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(TypechoContents record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table typecho_contents
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TypechoContents record);
}