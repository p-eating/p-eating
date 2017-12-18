package com.chinaredstar.eating.service.faceset;

import com.chinaredstar.eating.components.constants.FaceApiContants;
import com.chinaredstar.eating.components.utils.HttpUtils;
import com.chinaredstar.eating.model.faceset.CreateFacesetInputModel;
import com.chinaredstar.eating.model.faceset.CreateFacesetOutputModel;
import com.chinaredstar.eating.model.faceset.GetFacesetsInputModel;
import com.chinaredstar.eating.model.faceset.GetFacesetsOutputModel;
import com.chinaredstar.perseus.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;

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

        String response = post(FaceApiContants.CREATE_FACESET_API, createFacesetInputModel);

        return (CreateFacesetOutputModel) JsonUtil.fromJson(response, CreateFacesetOutputModel.class);
    }

    /**
     * 获取facesets
     *
     * @param getFacesetsInputModel
     * @return
     */
    @Override
    public GetFacesetsOutputModel getFacesets(GetFacesetsInputModel getFacesetsInputModel) throws Exception {

        String response = post(FaceApiContants.GET_FACESETS_API, getFacesetsInputModel);

        return (GetFacesetsOutputModel) JsonUtil.fromJson(response, GetFacesetsOutputModel.class);
    }


    /**
     * 获取字符
     *
     * @param url
     * @param params
     * @return
     * @throws Exception
     */
    public String post(String url, Object params) throws Exception {
        HashMap<String, String> param = (HashMap<String, String>) JsonUtil.fromJson(JsonUtil.toJson(params, false), HashMap.class);

        byte[] postData = HttpUtils.post(url, param, null);

        return new String(postData);
    }

}
