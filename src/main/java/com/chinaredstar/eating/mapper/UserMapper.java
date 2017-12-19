package com.chinaredstar.eating.mapper;

import com.chinaredstar.eating.model.user.UserModel;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    void seveUser(UserModel user);

    void seveUserFace(@Param("userId") Long userId, @Param("faceToken") String faceToken);

    UserModel findUserByFaceToken(@Param("faceToken") String faceToken);
}
