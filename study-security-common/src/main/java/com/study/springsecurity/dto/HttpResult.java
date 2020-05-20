package com.study.springsecurity.dto;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @TODO 自定义响应结果
 * @author fengb
 * @date 2020年5月20日 上午9:59:34
 */
public class HttpResult {

	/** 响应码 */
	private int code;
	/** 响应信息 */
	private String msg;
	/** 响应数据 */
	private Object data;

	public HttpResult() {
	}

	public HttpResult(Object data) {
		this.code = 200;
		this.msg = "OK";
		this.data = data;
	}

	public HttpResult(String msg, Object data) {
		this.code = 200;
		this.msg = msg;
		this.data = data;
	}

	public HttpResult(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static HttpResult ok() {
		return new HttpResult(null);
	}

	public static HttpResult ok(String msg) {
		return new HttpResult(msg, null);
	}

	public static HttpResult ok(Object data) {
		return new HttpResult(data);
	}

	public static HttpResult ok(String msg, Object data) {
		return new HttpResult(msg, data);
	}

	public static HttpResult build(int code, String msg) {
		return new HttpResult(code, msg, null);
	}

	public static HttpResult build(int code, String msg, Object data) {
		return new HttpResult(code, msg, data);
	}

	/**
	 * 将HttpResult对象转换成Json字符串
	 * 
	 * @return
	 */
	public String toJsonString() {
		return JSON.toJSONString(this);
	}

	/**
	 * 将Json字符串格式化为HttpResult对象
	 * 
	 * @param json
	 * @return
	 */
	public static HttpResult parse(String json) {
		HttpResult result = null;
		try {
			result = JSON.parseObject(json, HttpResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
