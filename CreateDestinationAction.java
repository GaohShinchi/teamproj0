//入力画面の動作
package com.internousdev.leo.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationAction extends ActionSupport implements SessionAware{
	private int keep_flag;
	private Map<String,Object> session;
	//ログインチェック
	public String execute(){
		//空かどうかを判定する、空であればsessionTimeoutを返す
		if(session.isEmpty()){
			return "sessionTimeout";
		}
		//保持フラグが立っていない場合sessionを削除し、SUCCESSを返す
		if(keep_flag != 1){
			session.remove("lname");
			session.remove("fname");
			session.remove("lnameKana");
			session.remove("fnameKana");
			session.remove("email");
			session.remove("tell");
			session.remove("adds");
		}
		return SUCCESS;
	}

	public int getKeep_flag(){
		return keep_flag;
	}

	public void setKeep_flag(int keep_flag){
		this.keep_flag = keep_flag;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
