package com.chinaredstar.eating.service.user;

import com.chinaredstar.eating.model.common.CommonInputModel;
import com.chinaredstar.eating.model.UserModel;

import java.io.InputStream;

/**
 * @description:
 * @author: chaoyue<chaoyue.fan @ chinaredstar.com>
 * @date: Create in 10:28 2017/12/19
 * @version: 1.0.0
 * @modified by:
 */
public interface UserService {

    /**
     * @description: 创建用户
     * @author: chaoyue
     * @param model
     * @return:
     * @date: Create in 10:31 2017/12/19
     * @modified by:
     */
    void createUser(UserModel model, InputStream imageFile)  throws Exception ;


    /**
     * @description: 上传图片
     * @author: chaoyue
     * @param model 入参model
     * @return: face_token
     * @date: Create in 10:36 2017/12/19
     * @modified by:
     */
    String detectImage(UserModel model, InputStream imageFile)  throws Exception ;
}
