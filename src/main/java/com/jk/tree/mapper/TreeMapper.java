package com.jk.tree.mapper;

import java.util.List;

import com.jk.tree.model.Tree;

public interface TreeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tree record);

    int insertSelective(Tree record);

    List<Tree> selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tree record);

    int updateByPrimaryKey(Tree record);
}