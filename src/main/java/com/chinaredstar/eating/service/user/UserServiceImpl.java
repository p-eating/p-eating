package com.chinaredstar.eating.service.user;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.chinaredstar.eating.components.constants.FaceApiContants;
import com.chinaredstar.eating.components.utils.HttpUtils;
import com.chinaredstar.eating.mapper.EatingUserFaceModelMapper;
import com.chinaredstar.eating.mapper.EatingUserModelMapper;
import com.chinaredstar.eating.model.EatingUserFaceModel;
import com.chinaredstar.eating.model.EatingUserModel;
import com.chinaredstar.eating.model.common.CommonInputModel;
import com.chinaredstar.eating.model.user.DetectFaceResultModel;
import com.chinaredstar.eating.model.user.DetectResultModel;
import com.chinaredstar.eating.model.UserModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: chaoyue<chaoyue.fan @ chinaredstar.com>
 * @date: Create in 10:28 2017/12/19
 * @version: 1.0.0
 * @modified by:
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private EatingUserModelMapper eatingUserModelMapper;

    @Resource
    private EatingUserFaceModelMapper eatingUserFaceModelMapper;

    /**
     * @param model
     * @description: 创建用户
     * @author: chaoyue
     * @return:
     * @date: Create in 10:31 2017/12/19
     * @modified by:
     */
    @Override
    public void createUser(UserModel model, InputStream imageFile)  throws Exception {
        CommonInputModel commonInputModel = new CommonInputModel();
        String facesetToken = detectImage(commonInputModel,imageFile);
        EatingUserModel eatingUserModel = new EatingUserModel();
        eatingUserModel.setGender(model.getGender());
        eatingUserModel.setName(model.getName());
        eatingUserModelMapper.insertSelective(eatingUserModel);
        EatingUserFaceModel faceModel = new EatingUserFaceModel();
        faceModel.setFaceToken(facesetToken);
        faceModel.setUserId(eatingUserModel.getId());
        eatingUserFaceModelMapper.insertSelective(faceModel);

    }

    /**
     * @param model 入参model
     * @description: 上传图片
     * @author: chaoyue
     * @return: face_token
     * @date: Create in 10:36 2017/12/19
     * @modified by:
     */
    @Override
    public String detectImage(CommonInputModel model, InputStream imageFile) throws Exception{
        try{
            HashMap map = new HashMap();
            map.put("image_file",input2byte(imageFile));
            DetectResultModel detectResultModel = HttpUtils.postBean(FaceApiContants.CREATE_DETECT_API, model, map, DetectResultModel.class);
            if (detectResultModel == null)throw new Exception("上传结果为空");
            List<DetectFaceResultModel> faces = detectResultModel.getFaces();
            if (CollectionUtils.isEmpty(faces)) throw new Exception("上传图片中未获取到脸部信息");
            return faces.get(0).getFaceToken();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }finally {
            imageFile.close();
        }
    }

    public static final byte[] input2byte(InputStream inStream) throws IOException{
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inStream.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        byte[] in2b = swapStream.toByteArray();
        return in2b;
    }
}
