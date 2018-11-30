package com.free.code.model;

/**
 * @ClassName RequestHeader
 * @Description TODO
 * @Author hsiangcn@sina.com
 * @Date 2018/11/30 10:25
 * @Version 1.0
 */
public class RequestHeader {

    /**
     * 服务版本
     */
    private String serviceVersion;

    /**
     * 用户唯一标识
     */
    private String userToken;

    /**
     *  来源
     */
    private String sourceID;

    /**
     * 客户端版本
     */
    private String clientVersion;

    /**
     * 手机号
     */
    private String phoneModels;

    /**
     * 请求时间
     */
    private Long requestTime;

    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getSourceID() {
        return sourceID;
    }

    public void setSourceID(String sourceID) {
        this.sourceID = sourceID;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public String getPhoneModels() {
        return phoneModels;
    }

    public void setPhoneModels(String phoneModels) {
        this.phoneModels = phoneModels;
    }

    public Long getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Long requestTime) {
        this.requestTime = requestTime;
    }
}
