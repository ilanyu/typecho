package com.lanyus.typecho.service;

import com.lanyus.typecho.dao.TypechoContentsMapper;
import com.lanyus.typecho.dao.TypechoRelationshipsMapper;
import com.lanyus.typecho.dao.TypechoUsersMapper;
import com.lanyus.typecho.domain.TypechoContents;
import com.lanyus.typecho.domain.TypechoUsers;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    public boolean login(String username, String password) {
        TypechoUsers typechoUsers = typechoUsersMapper.selectByName(username);
        System.out.println(typechoUsers.getPassword());
        System.out.println(password);
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
