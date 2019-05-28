package com.internousdev.leo.dto;

public class DestinationInfoDTO {

	private int id;
	private String userId,lname,fname,lnameKana,fnameKana,adds,tell,email;

//ID
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}

//ユーザーID
	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId = userId;
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
}