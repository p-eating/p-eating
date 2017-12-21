package com.chinaredstar.eating.service.user;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.chinaredstar.eating.components.constants.FaceApiContants;
import com.chinaredstar.eating.components.utils.HttpUtils;
import com.chinaredstar.eating.mapper.EatingUserFaceModelMapper;
import com.chinaredstar.eating.mapper.EatingUserModelMapper;
import com.chinaredstar.eating.mapper.UserMapper;
import com.chinaredstar.eating.model.EatingUserFaceModel;
import com.chinaredstar.eating.model.EmployeeModel;
import com.chinaredstar.eating.model.UserModel;
import com.chinaredstar.eating.model.common.CommonOutputModel;
import com.chinaredstar.eating.model.user.AddFaceModel;
import com.chinaredstar.eating.model.user.DetectFaceResultModel;
import com.chinaredstar.eating.model.user.DetectResultModel;
import com.chinaredstar.eating.web.exception.EatingException;
import com.chinaredstar.eating.web.exception.EatingExceptionCodeEnum;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: chaoyue<chaoyue.fan@chinaredstar.com>
 * @date: Create in 10:28 2017/12/19
 * @version: 1.0.0
 * @modified by:
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private EatingUserFaceModelMapper eatingUserFaceModelMapper;

    @Resource
    private UserMapper userMapper;

    public static final String EMAIL_SUFFIX = "@chinaredstar.com";
    /**
     * @param model
     * @description: 创建用户
     * @author: chaoyue
     * @return:
     * @date: Create in 10:31 2017/12/19
     * @modified by:
     */
    @Override
    public void createUser(UserModel model, InputStream imageFile) throws Exception {
        String facesetToken = detectImage(model, imageFile);
        AddFaceModel addFaceModel = new AddFaceModel();
        addFaceModel.setFaceTokens(facesetToken);
        HttpUtils.postBean(FaceApiContants.ADD_FACE_FACESET_API, addFaceModel, CommonOutputModel.class);
        String email = model.getGemail()+EMAIL_SUFFIX;
        EmployeeModel employeeByEmail = userMapper.findEmployeeByEmail(email);
        if (null == employeeByEmail) throw new EatingException(EatingExceptionCodeEnum.NOT_RESULT_EXCEPTION,"未获取到邮箱为:"+email+"的用户信息");
        EatingUserFaceModel faceModel = new EatingUserFaceModel();
        faceModel.setFaceToken(facesetToken);
        faceModel.setUserId(employeeByEmail.getEmployeeId());
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
    public String detectImage(UserModel model, InputStream imageFile) throws Exception {
        DetectResultModel detectResultModel = new DetectResultModel();
        if (null != imageFile) {
            HashMap map = new HashMap();
            map.put("image_file", input2byte(imageFile));
            try {
                detectResultModel = HttpUtils.postBean(FaceApiContants.CREATE_DETECT_API, model, map, DetectResultModel.class);
            }catch (Exception e) {
                if (e instanceof EatingException ){
                    throw new EatingException(EatingExceptionCodeEnum.NOT_RESULT_EXCEPTION,e.getMessage());
                }else {
                    e.printStackTrace();
                    throw new Exception(e.getMessage());
                }

            } finally {
                imageFile.close();
            }
        } else {
            detectResultModel = HttpUtils.postBean(FaceApiContants.CREATE_DETECT_API, model, DetectResultModel.class);
        }
        if (detectResultModel == null) throw new EatingException(EatingExceptionCodeEnum.NOT_RESULT_EXCEPTION,"上传结果为空");
        List<DetectFaceResultModel> faces = detectResultModel.getFaces();
        if (CollectionUtils.isEmpty(faces)) throw new EatingException(EatingExceptionCodeEnum.NOT_FACE_TOKEN_EXCEPTION,"上传图片中未获取到脸部信息");
        return faces.get(0).getFaceToken();
    }


    public static final byte[] input2byte(InputStream inStream) throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inStream.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        byte[] in2b = swapStream.toByteArray();
        return in2b;
    }
    /**
     * @Description: 根据图片地址转换为base64编码字符串
     * @Author:
     * @CreateTime:
     * @return
     */
    public static String getImageStr(String imgFile) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }
}
