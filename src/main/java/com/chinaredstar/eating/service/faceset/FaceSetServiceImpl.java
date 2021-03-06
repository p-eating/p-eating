package com.chinaredstar.eating.service.faceset;

import com.chinaredstar.eating.components.constants.FaceApiContants;
import com.chinaredstar.eating.components.utils.HttpUtils;
import com.chinaredstar.eating.model.faceset.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * @description: faceset
 * @author: fangjian<jian.fang@chinaredstar.com>
 * @date: Create in 14:31 2017/12/18
 * @modified by:
 */
@Service
public class FaceSetServiceImpl implements IFaceSetService {

    private static final Logger LOG = LoggerFactory.getLogger(FaceSetServiceImpl.class);


    /**
     * 创建faceset
     *
     * @param createFacesetInputModel
     * @return
     */
    @Override
    public CreateFacesetOutputModel createFaceset(CreateFacesetInputModel createFacesetInputModel) throws Exception {


        return HttpUtils.postBean(FaceApiContants.CREATE_FACESET_API, createFacesetInputModel, CreateFacesetOutputModel.class);
    }

    /**
     * 获取facesets
     *
     * @param getFacesetsInputModel
     * @return
     */
    @Override
    public GetFacesetsOutputModel getFacesets(GetFacesetsInputModel getFacesetsInputModel) throws Exception {


        return HttpUtils.postBean(FaceApiContants.GET_FACESETS_API, getFacesetsInputModel, GetFacesetsOutputModel.class);
    }

    /**
     * 获取facesets中faceTokens
     *
     * @param getFacesetsDetailInputModel
     * @return
     */
    @Override
    public GetFacesetsDetailOutputModel getFacesets(GetFacesetsDetailInputModel getFacesetsDetailInputModel) throws Exception {

        return HttpUtils.postBean(FaceApiContants.GET_DETAIL_FACESETS_API, getFacesetsDetailInputModel, GetFacesetsDetailOutputModel.class);
    }

    /**
     * 从faceset删除facetoken
     *
     * @param removeFacesetInputModel
     * @return
     */
    @Override
    public RemoveFacesetOutputModel removeFaceset(RemoveFacesetInputModel removeFacesetInputModel) throws Exception {

        return HttpUtils.postBean(FaceApiContants.REMOVE_FACE_FACESETS_API, removeFacesetInputModel, RemoveFacesetOutputModel.class);
    }


}
