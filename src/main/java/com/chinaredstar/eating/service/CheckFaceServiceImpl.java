package com.chinaredstar.eating.service;

import com.chinaredstar.eating.components.constants.FaceApiContants;
import com.chinaredstar.eating.components.utils.HttpUtils;
import com.chinaredstar.eating.mapper.UserMapper;
import com.chinaredstar.eating.model.UserModel;
import com.chinaredstar.eating.model.common.RestResultVo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;


/**
 * @Author: 周易(yi.zhou)
 * @Date: 2017/12/18 下午7:38
 * @Description:
 */
@Service
public class CheckFaceServiceImpl implements CheckFaceService{
    @Autowired
    private UserMapper userMapper;
    private static final Logger logger = LoggerFactory.getLogger(CheckFaceServiceImpl.class);
    private static final double CONFIDENCE = 80;
    @Override
    public RestResultVo checkFace(byte[] img) {
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, byte[]> byteMap = new HashMap<>();
        map.put("api_key", FaceApiContants.API_KEY);
        map.put("api_secret", FaceApiContants.API_SECRET);
        map.put("faceset_token", FaceApiContants.FACESET_TOKEN);
        byteMap.put("image_file", img);
        byte[] byteResult;
        try{
            //请求face++
            byteResult = HttpUtils.post(FaceApiContants.SEARCH_FACE_API, map, byteMap);
        }catch (Exception e) {
            logger.error("请求失败。",e);
            return new RestResultVo(-1,"请求失败。");
        }
        String str = new String(byteResult);
        JSONObject resultObject = new JSONObject(str);
        //先获取error信息;
        Object errorMessage = null;
        try {
            errorMessage = resultObject.get("error_message");
        } catch (JSONException e) {

        }
        //如果含有error信息表示请求失败。
        if(!StringUtils.isEmpty(errorMessage)){
            return new RestResultVo(-1,errorMessage.toString());
        }
        //获取返回结果
        JSONArray jsonArray;
        try {
            jsonArray = resultObject.getJSONArray("results");
        } catch (JSONException e) {
            return new RestResultVo(-1,"人脸识别失败。");
        }
        //如果结果为空
        if(jsonArray==null||jsonArray.length()<=0){
            return new RestResultVo(-1,"人脸识别失败。");
        }
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        double confidence = jsonObject.getDouble("confidence");
        String faceToken = jsonObject.getString("face_token");
        if(confidence < CONFIDENCE){
            return new RestResultVo(-1,"无法匹配脸部信息。");
        }
        UserModel user;
        try {
            user = userMapper.findUserByFaceToken(faceToken);
        } catch (Exception e) {
            logger.error("数据库连接失败。",e);
            return new RestResultVo(-1,"数据库连接失败。");
        }
        if(null == user){
            return new RestResultVo(-2,"用户不存在。");
        }
        return RestResultVo.getResult(user);
    }
}
