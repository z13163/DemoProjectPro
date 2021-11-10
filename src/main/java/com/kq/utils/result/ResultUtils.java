package com.kq.utils.result;

public class ResultUtils {
    public static final int SUCCESS = 0;
    public static final int ERROR = 1;

    public static ResponseBo success(){
        return general(SUCCESS,"成功",null);
    }
    public static ResponseBo success(String msg){
        return general(SUCCESS,msg,null);
    }
    public static ResponseBo success(Object data){
        return general(SUCCESS,null,data);
    }
    public static ResponseBo success(String msg, Object data){
        return general(SUCCESS,msg,data);
    }
    public static ResponseBo error(){
        return general(ERROR,"失败",null);
    }
    public static ResponseBo error(String msg){
        return general(ERROR,msg,null);
    }
    public static ResponseBo error(Object data){
        return general(ERROR,null,data);
    }
    public static ResponseBo error(String msg, Object data){
        return general(ERROR,msg,data);
    }

    public static ResponseBo general(int code, String msg, Object data){
        ResponseBo resultBo = new ResponseBo();
        resultBo.setCode(code);
        resultBo.setMsg(msg);
        resultBo.setData(data);
        return resultBo;
    }
}
