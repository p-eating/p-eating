package com.chinaredstar.eating.mapper;

import com.chinaredstar.eating.model.UserModel;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    UserModel findUser();

    void seveUser(UserModel user);

    void seveUserFace(@Param("userId") Long userId, @Param("faceToken") String faceToken);
}
