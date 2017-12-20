package com.chinaredstar.eating.components.constants;

import com.chinaredstar.eating.components.utils.ApplicationContextUtil;
import com.chinaredstar.eating.model.config.FaceApiConfigModel;

public class FaceApiContants {

    public static final String API_KEY;

    public static final String API_SECRET;

    public static final String FACESET_TOKEN;

    static {
        FaceApiConfigModel faceApiConfigModel = ApplicationContextUtil.getApplicationContext().getBean(FaceApiConfigModel.class);
        API_KEY = faceApiConfigModel.getKey();
        API_SECRET = faceApiConfigModel.getSecret();
        FACESET_TOKEN = faceApiConfigModel.getFacesetToken();
    }


    /**
     * faceSet create api
     */
    public static final String CREATE_FACESET_API = "https://api-cn.faceplusplus.com/facepp/v3/faceset/create";

    /**
     * faceSet get facesets detail
     */
    public static final String GET_DETAIL_FACESETS_API = "https://api-cn.faceplusplus.com/facepp/v3/faceset/getdetail";

    /**
     * remove face from faceset
     */
    public static final String REMOVE_FACE_FACESETS_API = "https://api-cn.faceplusplus.com/facepp/v3/faceset/removeface";

    /**
     * faceSet get facesets
     */
    public static final String GET_FACESETS_API = "https://api-cn.faceplusplus.com/facepp/v3/faceset/getfacesets";

    /**
     * faceSet addFace api
     */
    public static final String ADD_FACE_FACESET_API = "https://api-cn.faceplusplus.com/facepp/v3/faceset/addface";

    /**
     * search face api
     */
    public static final String SEARCH_FACE_API = "https://api-cn.faceplusplus.com/facepp/v3/search";


    /**
     * @description: 传入图片进行人脸检测和人脸分析 API。
     * @author: chaoyue
     * @return:
     * @date: Create in 10:47 2017/12/19
     * @modified by:
     */
    public static final String CREATE_DETECT_API = "https://api-cn.faceplusplus.com/facepp/v3/detect";
}
