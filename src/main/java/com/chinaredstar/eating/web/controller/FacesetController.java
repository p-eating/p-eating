package com.chinaredstar.eating.web.controller;

import com.chinaredstar.eating.model.common.RestResultVo;
import com.chinaredstar.eating.model.faceset.CreateFacesetInputModel;
import com.chinaredstar.eating.model.faceset.GetFacesetsDetailInputModel;
import com.chinaredstar.eating.model.faceset.GetFacesetsInputModel;
import com.chinaredstar.eating.service.faceset.IFaceSetService;
import com.chinaredstar.perseus.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @description:
 * @author: fangjian<jian.fang@chinaredstar.com>
 * @date: Create in 14:58 2017/12/18
 * @modified by:
 */
@RestController()
@RequestMapping("faceset")
public class FacesetController {


    private static final Logger LOG = LoggerFactory.getLogger(FacesetController.class);

    @Resource
    private IFaceSetService faceSetService;


    @RequestMapping(value = "/create", method = {RequestMethod.POST})
    public RestResultVo<Object> create(@RequestBody CreateFacesetInputModel createFacesetInputModel) throws Exception {
        LOG.info("param:[{}]", JsonUtil.toJson(createFacesetInputModel, false));

        return new RestResultVo(faceSetService.createFaceset(createFacesetInputModel));

    }

    @RequestMapping(value = "/facesets", method = {RequestMethod.POST})
    public RestResultVo<Object> facesets(@RequestBody GetFacesetsInputModel getFacesetsInputModel) throws Exception {
        LOG.info("param:[{}]", JsonUtil.toJson(getFacesetsInputModel, false));

        return new RestResultVo(faceSetService.getFacesets(getFacesetsInputModel));

    }

    @RequestMapping(value = "/detail", method = {RequestMethod.POST})
    public RestResultVo<Object> facesets(@RequestBody GetFacesetsDetailInputModel getFacesetsDetailInputModel) throws Exception {
        LOG.info("param:[{}]", JsonUtil.toJson(getFacesetsDetailInputModel, false));

        return new RestResultVo(faceSetService.getFacesets(getFacesetsDetailInputModel));

    }


}
