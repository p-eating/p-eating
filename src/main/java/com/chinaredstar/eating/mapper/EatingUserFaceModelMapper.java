package com.chinaredstar.eating.mapper;

import java.util.List;

import com.chinaredstar.eating.model.EatingUserFaceModel;
import com.chinaredstar.eating.model.EatingUserFaceModelExample;
import org.apache.ibatis.annotations.Param;

public interface EatingUserFaceModelMapper {
    long countByExample(EatingUserFaceModelExample example);

    int deleteByExample(EatingUserFaceModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EatingUserFaceModel record);

    int insertSelective(EatingUserFaceModel record);

    List<EatingUserFaceModel> selectByExample(EatingUserFaceModelExample example);

    EatingUserFaceModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EatingUserFaceModel record, @Param("example") EatingUserFaceModelExample example);

    int updateByExample(@Param("record") EatingUserFaceModel record, @Param("example") EatingUserFaceModelExample example);

    int updateByPrimaryKeySelective(EatingUserFaceModel record);

    int updateByPrimaryKey(EatingUserFaceModel record);
}