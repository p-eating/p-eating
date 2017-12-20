package com.chinaredstar.eating.web.controller;

import com.chinaredstar.eating.model.common.CommonInputModel;
import com.chinaredstar.eating.model.common.RestResultVo;
import com.chinaredstar.eating.model.UserModel;
import com.chinaredstar.eating.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @description:
 * @author: chaoyue<chaoyue.fan @ chinaredstar.com>
 * @date: Create in 11:00 2017/12/19
 * @version: 1.0.0
 * @modified by:
 */
@RestController()
@RequestMapping("user")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(FacesetController.class);

    @Resource
    private UserService userServiceImpl;


    @RequestMapping(value = "/createFile", method = {RequestMethod.POST})
    public RestResultVo<Object> createFile(UserModel model,@RequestParam("file") MultipartFile file) throws Exception {
        userServiceImpl.createUser(model,file.getInputStream());
        return new RestResultVo("success");
    }

    @RequestMapping(value = "/create", method = {RequestMethod.POST})
    public RestResultVo<Object> create(UserModel model) throws Exception {
        userServiceImpl.createUser(model,null);
        return new RestResultVo("success");
    }

    @RequestMapping(value = "/detect", method = {RequestMethod.POST})
    public RestResultVo<Object> detect(UserModel model,MultipartFile file) throws Exception {
        return new RestResultVo(userServiceImpl.detectImage(model,file.getInputStream()));

    }
}
