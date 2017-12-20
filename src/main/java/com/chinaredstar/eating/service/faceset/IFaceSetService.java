package com.chinaredstar.eating.service.faceset;

import com.chinaredstar.eating.model.faceset.*;

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

    /**
     * 获取facesets中faceTokens
     *
     * @param getFacesetsDetailInputModel
     * @return
     */
    GetFacesetsDetailOutputModel getFacesets(GetFacesetsDetailInputModel getFacesetsDetailInputModel) throws Exception;

    /**
     * 从faceset删除facetoken
     *
     * @param removeFacesetInputModel
     * @return
     */
    RemoveFacesetOutputModel removeFaceset(RemoveFacesetInputModel removeFacesetInputModel) throws Exception;


}
