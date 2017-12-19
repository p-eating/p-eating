package com.chinaredstar.eating.web.controller;

import com.chinaredstar.eating.model.common.PhotoReqVo;
import com.chinaredstar.eating.model.common.RestResultVo;
import com.chinaredstar.eating.service.CheckFaceService;
import com.chinaredstar.eating.service.CheckFaceServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: 周易(yi.zhou)
 * @Date: 2017/12/18 下午7:59
 * @Description:
 */
@RequestMapping(value = "/face")
@Controller
@ResponseBody
public class CheckFaceController {
    @Autowired
    private CheckFaceService checkFaceService;
    private static final Logger logger = LoggerFactory.getLogger(CheckFaceController.class);
    @RequestMapping(value = "/checkFace",method = RequestMethod.POST)
    public RestResultVo checkFace(@RequestBody PhotoReqVo req){
        String image = req.getImage();
        if(StringUtils.isEmpty(image)){
            return new RestResultVo(-1,"传入数据为空。");
        }
//        byte[] bytes = null;
//        if(image != null){
//            try {
//                long start = System.currentTimeMillis();
//                bytes = image.getBytes();
//                logger.info("获取字节所花时间："+(System.currentTimeMillis()-start));
//            } catch (IOException e) {
//                return new RestResultVo(-1,"数据转换失败。");
//            }
//        }
        RestResultVo restResultVo = checkFaceService.checkFace(image);
        return restResultVo;
    }
}
