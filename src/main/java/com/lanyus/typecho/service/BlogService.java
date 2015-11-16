package com.lanyus.typecho.service;

import com.lanyus.typecho.dao.TypechoContentsMapper;
import com.lanyus.typecho.dao.TypechoRelationshipsMapper;
import com.lanyus.typecho.domain.TypechoContents;
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
