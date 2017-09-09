package com.example.simples.sm.common.utils;

import com.alibaba.fastjson.JSONObject;


/**
 * @author tianyi
 *json工具类
 */
public class JsonUtils {
	
	/**错误Key*/
	private static final String ERROR_KEY = "msg";
	
	/**成功Key*/
	private static final String SUCCESS_KEY = "success";
	
	/**错误码*/
	private static final String CODE_KEY = "code";

	/**
	 * 返回系统成功JSON
	 * @param msg msg
	 * @return String
	 */
	public static String getSuccess(String msg){
		return result(true, msg);
	}
	/**
	 * 返回系统成功JSON
	 * @return String
	 */
	public static String getSuccess(){
		return result(true, "ok");
	}
	
	/**
	 * 返回系统成功JSONObject
	 * @return JSONObject
	 */
	public static JSONObject getSuccessJson(){
		return JSONObject.parseObject(getSuccess(""));
	}
	
	/**
	 * @since 1.0
	 * @param msg msg
	 * @return
	 * <br>创建时间：2016年9月14日 上午11:21:10
	 */
	public static JSONObject getSuccessJson(String msg){
		return JSONObject.parseObject(getSuccess(msg));
	}
	
	/**
	 * 返回系统失败JSON
	 * @param msg msg
	 * @return String
	 */
	public static String getFailure(String msg){
		return result(false, msg);
	}
	/**
	 * 返回系统失败JSON
	 * @param msg msg
	 * @return String
	 */
	public static String getFailure(String msg, Integer code){
		return result(false, msg,code);
	}

	/**
	 * 封装通用JSON返回结果
	 * @param success success
	 * @param msg msg
	 * @return String
	 */
	public static String result(boolean success, String msg){
		JSONObject result = new JSONObject();
		result.put(SUCCESS_KEY, success);
		result.put(ERROR_KEY, msg);
		return result.toString();
	}
	
	/**
	 * 返回系统成功JSONObject
	 * @param msg  msg
	 * @return  JSONObject
	 */
	public static JSONObject getFailureJson(String msg){
		return JSONObject.parseObject(getFailure(msg,-500));
	}
	
	
	/**
	 * @since 1.0
	 * @param success
	 * @param msg
	 * @param code
	 * @return
	 * <br><b>@author luoxx</b>
	 * <br>创建时间：2017年3月31日 下午2:21:19
	 */
	public static String result(boolean success, String msg, Integer code){
		JSONObject result = new JSONObject();
		result.put(SUCCESS_KEY, success);
		result.put(ERROR_KEY, msg);
		result.put(CODE_KEY, code);
		return result.toString();
	}
	
	/**
	 * 返回带错误码和错误信息的json
	 * @since 1.0
	 * @param msg
	 * @param code
	 * @return
	 * <br><b>@author luoxx</b>
	 * <br>创建时间：2017年3月31日 下午1:52:39
	 */
	public static JSONObject getFailureJson(String msg, Integer code){
		return JSONObject.parseObject(result(false, msg,code));
	}
	
	/**
	 * @since 1.0
	 * @param msg
	 * @param code
	 * @return
	 * <br><b>@author luoxx</b>
	 * <br>创建时间：2017年3月31日 下午2:23:05
	 */
	public static JSONObject getSuccessJson(String msg, Integer code){
		return JSONObject.parseObject(result(true, msg,code));
	}
	
}
