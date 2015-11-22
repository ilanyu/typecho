package com.lanyus.typecho.service;

import com.lanyus.typecho.dao.*;
import com.lanyus.typecho.domain.*;
import org.pegdown.PegDownProcessor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ly on 2015/11/16.
 */
@Service
public class BlogService {

    @Resource
    TypechoContentsMapper typechoContentsMapper;
    @Resource
    TypechoRelationshipsMapper typechoRelationshipsMapper;
    @Resource
    TypechoUsersMapper typechoUsersMapper;
    @Resource
    TypechoMetasMapper typechoMetasMapper;
    @Resource
    TypechoCommentsMapper typechoCommentsMapper;

    public boolean login(String username, String password) {
        TypechoUsers typechoUsers = typechoUsersMapper.selectByName(username);
        if (typechoUsers == null) {
            return false;
        }
        if (typechoUsers.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public List<TypechoContents> getBlog() {
        List<TypechoContents> typechoContentsList = typechoContentsMapper.selectAll();
        List<TypechoContents> typechoContentses = new ArrayList<TypechoContents>();
        for (TypechoContents typechoContents : typechoContentsList) {
            if (typechoRelationshipsMapper.selectByCid(typechoContents.getCid()) != null) {
                typechoContentses.add(typechoContents);
            }
        }
        return typechoContentses;
    }

    public List<BlogContent> getIndexBlog(int start,int limit) {
        List<TypechoContents> typechoContentsList = typechoContentsMapper.selectAllByLimit(start,limit);
        List<BlogContent> blogContents = new ArrayList<BlogContent>();
        for (TypechoContents typechoContents : typechoContentsList) {
            TypechoRelationshipsKey typechoRelationshipsKey = typechoRelationshipsMapper.selectByCid(typechoContents.getCid());
            if (typechoRelationshipsKey != null) {
                BlogContent blogContent = new BlogContent();
                int authorId = typechoContents.getAuthorid();
                blogContent.setAuthor(typechoUsersMapper.selectByPrimaryKey(authorId).getScreenname());
                blogContent.setAuthorId(String.valueOf(authorId));
                blogContent.setTitle(typechoContents.getTitle());
                blogContent.setCid(String.valueOf(typechoContents.getCid()));
                blogContent.setContent(new PegDownProcessor().markdownToHtml(typechoContents.getText()));
                TypechoMetas typechoMetas = typechoMetasMapper.selectByPrimaryKey(typechoRelationshipsKey.getMid());
                blogContent.setCategory(typechoMetas.getName());
                blogContent.setCategorySlug(typechoMetas.getSlug());
                blogContent.setComment(String.valueOf(typechoCommentsMapper.countByCid(typechoContents.getCid())));
                blogContent.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date(typechoContents.getCreated() * 1000L)));
                blogContents.add(blogContent);
            }
        }
        return blogContents;
    }

    public List<TypechoContents> getPage() {
        List<TypechoContents> typechoContentsList = typechoContentsMapper.selectAll();
        List<TypechoContents> typechoContentses = new ArrayList<TypechoContents>();
        for (TypechoContents typechoContents : typechoContentsList) {
            if (typechoRelationshipsMapper.selectByCid(typechoContents.getCid()) == null) {
                typechoContentses.add(typechoContents);
            }
        }
        return typechoContentses;
    }
}
