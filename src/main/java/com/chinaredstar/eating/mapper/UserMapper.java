package com.chinaredstar.eating.mapper;

import com.chinaredstar.eating.model.EmployeeModel;
import com.chinaredstar.eating.model.UserModel;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    void seveUser(UserModel user);

    void seveUserFace(@Param("userId") Long userId, @Param("faceToken") String faceToken);

    EmployeeModel findUserByFaceToken(@Param("faceToken") String faceToken);

    EmployeeModel findEmployeeByEmail(@Param("email") String email);
}
