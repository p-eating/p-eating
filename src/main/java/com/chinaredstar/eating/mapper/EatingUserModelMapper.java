package com.chinaredstar.eating.mapper;

import java.util.List;

import com.chinaredstar.eating.model.EatingUserModel;
import com.chinaredstar.eating.model.EatingUserModelExample;
import org.apache.ibatis.annotations.Param;

public interface EatingUserModelMapper {
    long countByExample(EatingUserModelExample example);

    int deleteByExample(EatingUserModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EatingUserModel record);

    int insertSelective(EatingUserModel record);

    List<EatingUserModel> selectByExample(EatingUserModelExample example);

    EatingUserModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EatingUserModel record, @Param("example") EatingUserModelExample example);

    int updateByExample(@Param("record") EatingUserModel record, @Param("example") EatingUserModelExample example);

    int updateByPrimaryKeySelective(EatingUserModel record);

    int updateByPrimaryKey(EatingUserModel record);
}