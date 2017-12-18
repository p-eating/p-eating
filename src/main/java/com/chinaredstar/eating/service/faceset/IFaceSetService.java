package com.chinaredstar.eating.service.faceset;

import com.chinaredstar.eating.model.faceset.CreateFacesetInputModel;
import com.chinaredstar.eating.model.faceset.CreateFacesetOutputModel;
import com.chinaredstar.eating.model.faceset.GetFacesetsInputModel;
import com.chinaredstar.eating.model.faceset.GetFacesetsOutputModel;

/**
 * @description: faceset
 * @author: fangjian<jian.fang@chinaredstar.com>
 * @date: Create in 14:31 2017/12/18
 * @modified by:
 */
public interface IFaceSetService {


    /**
     * 创建faceset
     *
     * @param createFacesetInputModel
     * @return
     */
    CreateFacesetOutputModel createFaceset(CreateFacesetInputModel createFacesetInputModel) throws Exception;


    /**
     * 获取facesets
     *
     * @param getFacesetsInputModel
     * @return
     */
    GetFacesetsOutputModel getFacesets(GetFacesetsInputModel getFacesetsInputModel) throws Exception;


}
