//確認画面、SUCCESSとERRORを返す*crDCon,crD.jsp
package com.internousdev.leo.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.leo.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationConfirmAction extends ActionSupport implements SessionAware{

	private String lname,fname,lnameKana,fnameKana,email,tell,adds;

	//エラーメッセージ(E)
	private List<String> lnameE,fnameE,lnameKanaE,fnameKanaE,emailE,tellE,addsE;

	private Map<String,Object> session;

	//ログインチェック
	public String execute(){
		if(session.isEmpty()){
			return "sessionTimeout";
		}
		//resに結果を入力(ERROR or SUCCESS)
		String result =ERROR;

		//格納
		session.put("lname",lname);
		session.put("fname",fname);
		session.put("lnameKana",lnameKana);
		session.put("fnameKana",fnameKana);
		session.put("email",email);
		session.put("tell",tell);
		session.put("adds",adds);

		//チェック「項目名、値、最小文字数、最大文字数、半角英字、漢字、ひらがな、半角数字、半角記号、カタカナ、スペース」
		InputChecker inC = new InputChecker();
		lnameE = inC.doCheck("姓",lname,1,16,true,true,true,false,false,false,false);
		fnameE = inC.doCheck("名",fname,1,16,true,true,true,false,false,false,false);
		lnameKanaE = inC.doCheck("姓ふりがな",lnameKana,1,16,false,false,true,false,false,false,false);
		fnameKanaE = inC.doCheck("名ふりがな",fnameKana,1,16,false,false,true,false,false,false,false);
		emailE = inC.doCheckForEmail("メールアドレス",email,10,32);
		tellE = inC.doCheck("電話番号",tell,10,13,false, false, false, true, false, false, false);
		addsE = inC.doCheck("住所",adds,10,50,true, true, true, true, false, true, false);

		//それぞれのエラーメッセージに入力されているか判定
		//エラーメッセージがある場合はERRORを返す
		//エラーメッセージがない場合はSUCCESSを返す
		if(lnameE.size() > 0
		||fnameE.size() > 0
		||lnameKanaE.size() > 0
		||fnameKanaE.size() > 0
		||emailE.size() > 0
		||tellE.size() > 0
		||addsE.size() > 0){
			result = ERROR;
		}else{
			result = SUCCESS;
		}

		return result;

	}

	//ラストネーム(苗字)
		public String getLname(){
			return lname;
		}
		public void setLname(String lname){
			this.lname = lname;
		}

	//ファーストネーム(名前)
		public String getFname(){
			return fname;
		}
		public void setFname(String fname){
			this.fname = fname;
		}

	//苗字かな
		public String getLnameKana(){
			return lnameKana;
		}
		public void setLnameKana(String lnameKana){
			this.lnameKana = lnameKana;
		}

	//名前かな
		public String getFnameKana(){
			return fnameKana;
		}
		public void setFnameKana(String fnameKana){
			this.fnameKana = fnameKana;
		}

	//メールアドレス
		public String getEmail(){
			return email;
		}
		public void setEmail(String email){
			this.email = email;
		}

	//電話番号
		public String getTell(){
			return tell;
		}
		public void setTell(String tell){
			this.tell = tell;
		}

	//住所
		public String getAdds(){
			return adds;
		}
		public void setAdds(String adds){
			this.adds = adds;
		}

	//苗字エラーメッセージ
		public List<String> getLnameE(){
			return lnameE;
		}
		public void setLnameE(List<String> lnameE){
			this.lnameE = lnameE;
		}

	//名前エラーメッセージ
		public List<String> getFnameE(){
			return fnameE;
		}
		public void setFnameE(List<String> fnameE){
			this.fnameE = fnameE;
		}

	//苗字かなエラーメッセージ
		public List<String> getLnameKanaE(){
			return lnameKanaE;
		}
		public void setLnameKanaE(List<String> lnameKanaE){
			this.lnameKanaE = lnameKanaE;
		}

	//名前かなエラーメッセージ
		public List<String> getFnameKanaE(){
			return fnameKanaE;
		}
		public void setFname_kanaE(List<String> fnameKanaE){
			this.fnameKanaE = fnameKanaE;
		}

	//メルアドエラーメッセージ
		public List<String> getEmailE(){
			return emailE;
		}
		public void setEmailE(List<String> emailE){
			this.emailE = emailE;
		}

	//電話番号エラーメッセージ
		public List<String> getTellE(){
			return tellE;
		}
		public void setTellE(List<String> tellE){
			this.tellE = tellE;
		}

	//住所エラーメッセージ
		public List<String> getAddsE(){
			return addsE;
		}
		public void setAddE(List<String> addsE){
			this.addsE = addsE;
		}

	//マップ
		public Map<String,Object> getSession(){
			return session;
		}
		public void setSession(Map<String,Object> session){
			this.session = session;
		}

}
