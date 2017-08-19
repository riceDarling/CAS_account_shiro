package com.account.utils;

public class ResponseModel<T> {

	private String msg = "失败";
	private boolean success = false;
	private T obj;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
	/**
	 * 
	 * @param entity 返回的实体
	 * @param msg 返回字符串提示
	 */
	public void isSuccessMsg(T entity,String msg){
		this.success=true;
		this.setMsg(msg);
		this.setObj(entity);
	}
	
	/**
	 * 
	 * @param msg 返回字符串提示
	 */
	public void isErrorMsg(String msg){
		this.success=false;
		this.setMsg(msg);
		this.setObj(null);
	}

	/**
     * 成功提示
     * @param message
     * @param result
     */
    public void  setSuccessMessage(String msg, T res){
    	this.setSuccess(true);
        this.setMsg(msg);
        this.setObj(res);
    }
    /**
     * 失败提示
     * @param message
     * @param result
     */
    public void  setErrorMessage(String msg, T res){
        this.setMsg(msg);
        this.setObj(res);
    }
}
