package com.chinaredstar.eating.web.exception;

import com.chinaredstar.eating.components.utils.JsonUtils;
import com.chinaredstar.eating.model.common.RestResultCode;
import com.chinaredstar.eating.model.common.RestResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 全局异常处理
 * @author: fangjian<jian.fang@chinaredstar.com>
 * @date: Create in 14:01 2017/12/19
 * @modified by:
 */
@Configuration
@Order(0)
public class GlobalExceptionResolver implements HandlerExceptionResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        LOGGER.info("GlobalExceptionResolver...");
        RestResultVo restResultVo = new RestResultVo();

        if (ex instanceof EatingException) {
            LOGGER.info("EatingException...");
            EatingException e = (EatingException) ex;
            EatingExceptionCodeEnum code = e.getCode();
            if (null != code) {
                restResultVo.setCode(code.getCode());
                restResultVo.setMessage(StringUtils.isEmpty(e.getMessage()) ? code.getMsg() : e.getMessage());
            } else {
                restResultVo.setCode(EatingExceptionCodeEnum.UNKNOWN_ERROR.getCode());
                restResultVo.setMessage(EatingExceptionCodeEnum.UNKNOWN_ERROR.getMsg() + "|" + e.getMessage());
            }
        } else if (ex instanceof MethodArgumentNotValidException) {
            LOGGER.info("MethodArgumentNotValidException...");
            MethodArgumentNotValidException e = (MethodArgumentNotValidException) ex;
            List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
            Map<String, String> msg = new LinkedHashMap<>();
            if (!CollectionUtils.isEmpty(fieldErrors)) {
                for (FieldError fieldError : fieldErrors) {
                    if (null == fieldError) {
                        continue;
                    }
                    msg.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
            }
            restResultVo.setCode(RestResultCode.C400.getCode());
            restResultVo.setMessage(RestResultCode.C400.getDesc());
            restResultVo.setDataMap(msg.toString());
        } else {
            restResultVo.setCode(RestResultCode.C500.getCode());
            restResultVo.setMessage(RestResultCode.C500.getDesc());
            restResultVo.setDataMap(ex.getMessage());
            LOGGER.error("500 error===:{}", ex);
        }

        MappingJackson2JsonView view = new MappingJackson2JsonView();
        view.setAttributesMap(JsonUtils.toBean(JsonUtils.toJsonString(restResultVo), HashMap.class));

        ModelAndView mv = new ModelAndView();
        mv.setView(view);
        return mv;
    }
}
