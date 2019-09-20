package com.gm.base;

/**
 * @Description: 封装json，所有controller都返回这个对象
 * @Author: guomeng
 * @Date: 2019/9/20 8:45
 **/
public class ResultJSONDto {

    private String msg;   //提示消息
    private Boolean success;   //结果
    private Object data;   //数据

    public ResultJSONDto() {

    }
    public ResultJSONDto(Boolean success) {
        this.success = success;
    }
    public ResultJSONDto(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }
    public ResultJSONDto(Boolean success, Object data) {
        this.success = success;
        this.data = data;
    }
    public ResultJSONDto(Boolean success, String msg, Object data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
