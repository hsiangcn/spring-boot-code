package com.free.code.utils;

import com.free.code.constant.ResultSuccess;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultMessageUtils {

    public static Map<String, Object> resultSuccess() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", ResultSuccess.OPERATION_SUCCESS.getCode());
        result.put("message", ResultSuccess.OPERATION_SUCCESS.getMessage());
        return result;
    }

    public static Map<String, Object> resultSuccess(String message) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", ResultSuccess.OPERATION_SUCCESS.getCode());
        if (StringUtils.isEmpty(message))
            result.put("message", ResultSuccess.OPERATION_SUCCESS.getMessage());
        else
            result.put("message", message);
        return result;
    }

    public static Map<String, Object> resultFailed() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", ResultSuccess.OPERATION_FAILED.getCode());
        result.put("message", ResultSuccess.OPERATION_FAILED.getMessage());
        return result;
    }

    public static Map<String, Object> resultFailed(String message) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", ResultSuccess.OPERATION_FAILED.getCode());
        if (StringUtils.isEmpty(message))
            result.put("message", ResultSuccess.OPERATION_FAILED.getMessage());
        else
            result.put("message", message);
        return result;
    }

    public static Map<String, Object> resultError() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", ResultSuccess.OPERATION_ERROR.getCode());
        result.put("message", ResultSuccess.OPERATION_ERROR.getMessage());
        return result;
    }

    public static Map<String, Object> resultError(String message) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", ResultSuccess.OPERATION_ERROR.getCode());
        if (StringUtils.isEmpty(message))
            result.put("message", ResultSuccess.OPERATION_ERROR.getMessage());
        else
            result.put("message", message);
        return result;
    }

    public static Map<String, Object> result(String code, String message) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", code);
        result.put("message", message);
        return result;
    }

    public static Map<String, Object> result(ResultSuccess resultSuccess) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", resultSuccess.getCode());
        result.put("message", resultSuccess.getMessage());
        return result;
    }

    public static Map<String, Object> resultSuccessObject(Object obj) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", ResultSuccess.OPERATION_SUCCESS.getCode());
        result.put("message", ResultSuccess.OPERATION_SUCCESS.getMessage());
        result.put("data", obj);
        return result;
    }

    public static Map<String, Object> resultSuccessObject(String code, String message, Object obj) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", code);
        result.put("message", message);
        result.put("data", obj);
        return result;
    }

    public static Map<String, Object> resultSuccessList(List<Object> lists) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", ResultSuccess.OPERATION_SUCCESS.getCode());
        result.put("message", ResultSuccess.OPERATION_SUCCESS.getMessage());
        result.put("data", lists);
        return result;
    }

    public static Map<String, Object> resultSuccessList(String code, String message, List<Object> lists) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", code);
        result.put("message", message);
        result.put("data", lists);
        return result;
    }

    public static Map<String, Object> resultSuccessList(Map<Object, Object> maps) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", ResultSuccess.OPERATION_SUCCESS.getCode());
        result.put("message", ResultSuccess.OPERATION_SUCCESS.getMessage());
        result.put("data", maps);
        return result;
    }

    public static Map<String, Object> resultSuccessList(String code, String message, Map<Object, Object> maps) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", code);
        result.put("message", message);
        result.put("data", maps);
        return result;
    }

}
