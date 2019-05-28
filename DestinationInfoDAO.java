package com.internousdev.leo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.leo.dto.DestinationInfoDTO;
import com.internousdev.leo.util.DBConnector;

public class DestinationInfoDAO {

	public int ins(String userId,
			String lname,
			String fname,
			String lnameKana,
			String fnameKana,
			String email,
			String tell,
			String adds){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;
		//情報の挿入を準備
		String sql = "insert into destination_info(user_id, family_name, first_name, family_name_kana, first_name_kana, email, tel_number, user_address, regist_date, update_date)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, now(), now())";

		//実行処理
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,userId);
			ps.setString(2,lname);
			ps.setString(3,fname);
			ps.setString(4,lnameKana);
			ps.setString(5,fnameKana);
			ps.setString(6,email);
			ps.setString(7,tell);
			ps.setString(8,adds);
			count = ps.executeUpdate();

		//エラーの場合
		}catch (SQLException e){
			e.printStackTrace();
		//必ずcloseを行い、処理に失敗していないか確認する
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	return count;
	}

	public List<DestinationInfoDTO> getDestinationInfo(String userId){
		DBConnector db = new DBConnector();
		Connection con= db.getConnection();
		List<DestinationInfoDTO> DTOList = new ArrayList<DestinationInfoDTO>();

		//user_idで参照
		String sql = "SELECT id, family_name, first_name, family_name_kana, first_name_kana, user_address, tel_number, email FROM destination_info WHERE user_id = ?";

		//userIdをセットして実行処理
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,userId);
			ResultSet res = ps.executeQuery();

			//next
			while(res.next()){
				DestinationInfoDTO DTO = new DestinationInfoDTO();
				DTO.setId(res.getInt("id"));
				DTO.setLname(res.getString("family_name"));
				DTO.setFname(res.getString("first_name"));
				DTO.setLnameKana(res.getString("family_name_kana"));
				DTO.setFnameKana(res.getString("first_name_kana"));
				DTO.setAdds(res.getString("user_address"));
				DTO.setTell(res.getString("tel_number"));
				DTO.setEmail(res.getString("email"));
				DTOList.add(DTO);
			}
		//エラーの場合
		}catch(SQLException e){
			e.printStackTrace();
		//必ずcloseを行い、処理に失敗していないか確認する
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return DTOList;
	}

	public int deleteDestination(String id){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		//該当するidのdestination_infoデータを削除する
		String sql = "DELETE FROM destination_info WHERE id = ?";
		int count = 0;

		//idをセットして実行処理
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			count = ps.executeUpdate();
		//エラーの場合
		}catch(SQLException e){
			e.printStackTrace();
		//必ずcloseを行い、処理に失敗していないか確認する
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return count;
	}

}