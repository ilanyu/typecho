package com.lanyus.typecho.service;

import com.lanyus.typecho.dao.*;
import com.lanyus.typecho.domain.*;
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

    public BlogContent getBlog(int cid) {
        TypechoContents typechoContents = typechoContentsMapper.selectByPrimaryKey(cid);
        BlogContent blogContent = new BlogContent();
        int authorId = typechoContents.getAuthorid();
        blogContent.setAuthor(typechoUsersMapper.selectByPrimaryKey(authorId).getScreenname());
        blogContent.setAuthorId(String.valueOf(authorId));
        blogContent.setTitle(typechoContents.getTitle());
        blogContent.setCid(String.valueOf(typechoContents.getCid()));
        blogContent.setContent(typechoContents.getText());
        TypechoRelationshipsKey typechoRelationshipsKey = typechoRelationshipsMapper.selectByCid(typechoContents.getCid());
        TypechoMetas typechoMetas = typechoMetasMapper.selectByPrimaryKey(typechoRelationshipsKey.getMid());
        blogContent.setCategory(typechoMetas.getName());
        blogContent.setCategorySlug(typechoMetas.getSlug());
        blogContent.setComment(String.valueOf(typechoCommentsMapper.countByCid(typechoContents.getCid())));
        blogContent.setAllowComment(typechoContents.getAllowcomment());
        blogContent.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date(typechoContents.getCreated() * 1000L)));
        return blogContent;
    }

    public List<BlogContent> getIndexBlog() {
        List<TypechoContents> typechoContentsList = typechoContentsMapper.selectAll();
        List<BlogContent> blogContents = new ArrayList<BlogContent>();
        for (TypechoContents typechoContents : typechoContentsList) {
            TypechoRelationshipsKey typechoRelationshipsKey = typechoRelationshipsMapper.selectByCid(typechoContents.getCid());
            if (typechoContents.getType().equals("post")) {
                BlogContent blogContent = new BlogContent();
                int authorId = typechoContents.getAuthorid();
                blogContent.setAuthor(typechoUsersMapper.selectByPrimaryKey(authorId).getScreenname());
                blogContent.setAuthorId(String.valueOf(authorId));
                blogContent.setTitle(typechoContents.getTitle());
                blogContent.setCid(String.valueOf(typechoContents.getCid()));
                blogContent.setContent(typechoContents.getText());
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

    public List<BlogContent> getNewBlogList() {
        List<TypechoContents> typechoContentsList = typechoContentsMapper.selectAll();
        List<BlogContent> blogContents = new ArrayList<BlogContent>();
        for (TypechoContents typechoContents : typechoContentsList) {
            if (typechoContents.getType().equals("post")) {
                BlogContent blogContent = new BlogContent();
                blogContent.setTitle(typechoContents.getTitle());
                blogContent.setCid(String.valueOf(typechoContents.getCid()));
                blogContents.add(blogContent);
            }
        }
        return blogContents;
    }

    public List<Page> getPageList() {
        List<TypechoContents> typechoContentsList = typechoContentsMapper.selectAllOrderBy();
        List<Page> pages = new ArrayList<Page>();
        for (TypechoContents typechoContents : typechoContentsList) {
            if (typechoContents.getType().equals("page")) {
                Page page = new Page();
                page.setCid(String.valueOf(typechoContents.getCid()));
                page.setContent(typechoContents.getText());
                page.setTitle(typechoContents.getTitle());
                pages.add(page);
            }
        }
        return pages;
    }

    public Page getPage(int cid) {
        TypechoContents typechoContents = typechoContentsMapper.selectByPrimaryKey(cid);
        Page page = new Page();
        page.setTitle(typechoContents.getTitle());
        page.setContent(typechoContents.getText());
        page.setCid(String.valueOf(cid));
        page.setAllowComment(typechoContents.getAllowcomment());
        return page;
    }

    public List<BlogContent> getSearch(String wd) {
        List<TypechoContents> typechoContentsList = typechoContentsMapper.selectLike("%" + wd + "%");
        List<BlogContent> blogContents = new ArrayList<BlogContent>();
        for (TypechoContents typechoContents : typechoContentsList) {
            if (typechoContents.getType().equals("post")) {
                BlogContent blogContent = new BlogContent();
                int authorId = typechoContents.getAuthorid();
                blogContent.setAuthor(typechoUsersMapper.selectByPrimaryKey(authorId).getScreenname());
                blogContent.setAuthorId(String.valueOf(authorId));
                blogContent.setTitle(typechoContents.getTitle());
                blogContent.setCid(String.valueOf(typechoContents.getCid()));
                blogContent.setContent(typechoContents.getText());
                TypechoRelationshipsKey typechoRelationshipsKey = typechoRelationshipsMapper.selectByCid(typechoContents.getCid());
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
}
