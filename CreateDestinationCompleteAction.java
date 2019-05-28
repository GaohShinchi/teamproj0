package com.internousdev.leo.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.leo.dao.DestinationInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationCompleteAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	//ログインチェック
	public String execute(){
		if(session.isEmpty()){
			return "sessionTimeout";
	}
	//resに結果を入力(ERROR or SUCCESS)
	String result = ERROR;
	DestinationInfoDAO DAO = new DestinationInfoDAO();

	//セッションデータ登録処理
	int count = DAO.ins(
			String.valueOf(session.get("userId")),
			String.valueOf(session.get("lname")),
			String.valueOf(session.get("fname")),
			String.valueOf(session.get("lnameKana")),
			String.valueOf(session.get("fnameKana")),
			String.valueOf(session.get("email")),
			String.valueOf(session.get("tell")),
			String.valueOf(session.get("adds"))
			);

		if(count > 0) {
			result = SUCCESS;
		}
		//セッションの入力情報を削除する
		session.remove("lname");
		session.remove("fname");
		session.remove("lnameKana");
		session.remove("fnameKana");
		session.remove("email");
		session.remove("tell");
		session.remove("adds");

		return result;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
