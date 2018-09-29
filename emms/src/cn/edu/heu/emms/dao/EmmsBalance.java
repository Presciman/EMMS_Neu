package cn.edu.heu.emms.dao;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




import cn.edu.heu.emms.common.DBUtil;
import cn.edu.heu.emms.javabean.EmmsBalence;
import cn.edu.heu.emms.javabean.EmmsEqt;

public class EmmsBalance 
{
	public ArrayList<EmmsBalence> queryaUser(int uno,int start,int size)
	{
		ArrayList<EmmsBalence> result = new ArrayList<EmmsBalence>();
		Connection con = null;
		PreparedStatement st = null;
        ResultSet rs = null;
        
        con = DBUtil.getConnection();
        try {
        	StringBuilder sql = new StringBuilder();
        	sql.append(" select * from emms_balance where 1=1 ");
        	if(uno !=-1){
        		sql.append(" and user_no = ?");
        	}
        	sql.append(" limit ?, ?");
			st = con.prepareStatement(sql.toString());
			int index=1;
			if(uno !=-1){
				st.setInt(index++,uno);
			}

			st.setInt(index++, start);
			st.setInt(index++, size);
			rs = st.executeQuery();
			
			while(rs.next())
			{
				EmmsBalence user = new EmmsBalence();
				user.setUserno(rs.getInt("user_no"));
				user.setName(rs.getString("user_addr"));
				user.setCom(rs.getString("user_com"));
				user.setContact(rs.getString("user_contact"));
				user.setGroup(rs.getString("user_group"));
				user.setId(rs.getString("user_id"));
				user.setName(rs.getString("user_name"));
				user.setPhone(rs.getString("user_phone"));
				user.setTel(rs.getString("user_tel"));
				user.setRepno(rs.getInt("rep_no"));
		//		user.setEtime(rs.getTimestamp("rep_etime"));
				user.setPrice(rs.getFloat("rep_price"));
				user.setStatus(rs.getString("rep_status"));
				user.setStime(rs.getTimestamp("rep_stime"));
				user.setEqtno(rs.getInt("eqt_no"));
				user.setType(rs.getString("eqt_type"));
				user.setBrand(rs.getString("eqt_brand"));
				user.setModel(rs.getString("eqt_model"));
				user.setSeriesnumber(rs.getString("eqt_seriesnumber"));
				user.setRecordno(rs.getInt("record_no"));
			//	user.setTime(rs.getTimestamp("record_time"));
			//	user.setReptime(rs.getTimestamp("record_reptime"));
				user.setSalary(rs.getFloat("record_salary"));
				user.setPerson(rs.getString("record_person"));
				user.setEngno(rs.getInt("eng_no"));
				user.setMaterialprice(rs.getFloat("record_materialprice"));
				user.setCptno(rs.getInt("cpt_no"));
				user.setSum(rs.getInt("cpt_sum"));
				user.setDbno(rs.getInt("db_no"));
				user.setCprice(rs.getFloat("db_cprice"));
				user.setPromise(rs.getString("record_promise"));
				user.setAttention(rs.getString("record_attention"));
				result.add(user);
			}
			//Return boolean value to make sure the information has been successfully queried.
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(rs, st, con);
		}
        return result;
	}
	public int queryaUser(int uno)
	{
		int result=0;
		Connection con = null;
		PreparedStatement st = null;
        ResultSet rs = null;
        
        con = DBUtil.getConnection();
        try {
        	StringBuilder sql = new StringBuilder();
        	sql.append(" select count(*) from emms_balance where 1=1 ");
        	if(uno != -1){
        		sql.append(" and user_no = ?");
        	}
        	
			st = con.prepareStatement(sql.toString());
			int index=1;
			if(uno !=-1){
				st.setInt(index++,uno);
			}

			
			rs = st.executeQuery();
			
			while(rs.next())
			{
				result=rs.getInt(1);
			}
			//Return boolean value to make sure the information has been successfully queried.
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(rs, st, con);
		}
        return result;
	}
	
	
	public EmmsBalence queryUser(int uno)
	{
		EmmsBalence user = new EmmsBalence();
		Connection con = null;
		PreparedStatement st = null;
        ResultSet rs = null;
        
        con = DBUtil.getConnection();
        try {
        	StringBuilder sql = new StringBuilder();
        	sql.append(" select * from emms_balance where 1=1 ");
        	if(uno !=-1){
        		sql.append(" and record_no = ?");
        	}
        	
			st = con.prepareStatement(sql.toString());
			int index=1;
			if(uno !=-1){
				st.setInt(index++,uno);
			}

	
	
			rs = st.executeQuery();
			
			while(rs.next())
			{
				user.setUserno(rs.getInt("user_no"));
				user.setName(rs.getString("user_addr"));
				user.setCom(rs.getString("user_com"));
				user.setContact(rs.getString("user_contact"));
				user.setGroup(rs.getString("user_group"));
				user.setId(rs.getString("user_id"));
				user.setName(rs.getString("user_name"));
				user.setPhone(rs.getString("user_phone"));
				user.setTel(rs.getString("user_tel"));
				user.setRepno(rs.getInt("rep_no"));
				//user.setEtime(rs.getTimestamp("rep_etime"));
				user.setPrice(rs.getFloat("rep_price"));
				user.setStatus(rs.getString("rep_status"));
				user.setStime(rs.getTimestamp("rep_stime"));
				user.setEqtno(rs.getInt("eqt_no"));
				user.setType(rs.getString("eqt_type"));
				user.setBrand(rs.getString("eqt_brand"));
				user.setModel(rs.getString("eqt_model"));
				user.setSeriesnumber(rs.getString("eqt_seriesnumber"));
				user.setRecordno(rs.getInt("record_no"));
			//	user.setTime(rs.getTimestamp("record_time"));
				//user.setReptime(rs.getTimestamp("record_reptime"));
				user.setSalary(rs.getFloat("record_salary"));
				user.setPerson(rs.getString("record_person"));
				user.setEngno(rs.getInt("eng_no"));
				user.setMaterialprice(rs.getFloat("record_materialprice"));
				user.setCptno(rs.getInt("cpt_no"));
				user.setSum(rs.getInt("cpt_sum"));
				user.setDbno(rs.getInt("db_no"));
				user.setCprice(rs.getFloat("db_cprice"));
				user.setPromise(rs.getString("record_promise"));
				user.setAttention(rs.getString("record_attention"));
			}
			//Return boolean value to make sure the information has been successfully queried.
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(rs, st, con);
		}
        return user;
	}
	
	
	public EmmsBalence queryUsers(int uno)
	{
		EmmsBalence user = new EmmsBalence();
		Connection con = null;
		PreparedStatement st = null;
        ResultSet rs = null;
        
        con = DBUtil.getConnection();
        try {
        	StringBuilder sql = new StringBuilder();
        	sql.append(" select * from emms_balance where 1=1 ");
        	if(uno !=-1){
        		sql.append(" and record_no = ?");
        	}
        	
			st = con.prepareStatement(sql.toString());
			int index=1;
			if(uno !=-1){
				st.setInt(index++,uno);
			}

			rs = st.executeQuery();
			
			while(rs.next())
			{
				user.setUserno(rs.getInt("user_no"));
				user.setName(rs.getString("user_addr"));
				user.setCom(rs.getString("user_com"));
				user.setContact(rs.getString("user_contact"));
				user.setGroup(rs.getString("user_group"));
				user.setId(rs.getString("user_id"));
				user.setName(rs.getString("user_name"));
				user.setPhone(rs.getString("user_phone"));
				user.setTel(rs.getString("user_tel"));
				user.setRepno(rs.getInt("rep_no"));
			//	user.setEtime(rs.getTimestamp("rep_etime"));
				user.setPrice(rs.getFloat("rep_price"));
				user.setStatus(rs.getString("rep_status"));
				user.setStime(rs.getTimestamp("rep_stime"));
				user.setEqtno(rs.getInt("eqt_no"));
				user.setType(rs.getString("eqt_type"));
				user.setBrand(rs.getString("eqt_brand"));
				user.setModel(rs.getString("eqt_model"));
				user.setSeriesnumber(rs.getString("eqt_seriesnumber"));
				user.setRecordno(rs.getInt("record_no"));
			//	user.setTime(rs.getTimestamp("record_time"));
			//	user.setReptime(rs.getTimestamp("record_reptime"));
				user.setSalary(rs.getFloat("record_salary"));
				user.setPerson(rs.getString("record_person"));
				user.setEngno(rs.getInt("eng_no"));
				user.setMaterialprice(rs.getFloat("record_materialprice"));
				user.setCptno(rs.getInt("cpt_no"));
				user.setSum(rs.getInt("cpt_sum"));
				user.setDbno(rs.getInt("db_no"));
				user.setCprice(rs.getFloat("db_cprice"));
				user.setPromise(rs.getString("record_promise"));
				user.setAttention(rs.getString("record_attention"));
			}
			//Return boolean value to make sure the information has been successfully queried.
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(rs, st, con);
		}
        return user;
	}
	
	public int queryaUser(java.sql.Timestamp date,int recordno)
	{
		int result=0;
		Connection con = null;
		PreparedStatement st = null;
        ResultSet rs = null;
        
        con = DBUtil.getConnection();
        try {
        	StringBuilder sql = new StringBuilder();
        	sql.append(" select * from emms_balance where 1=1 ");
        	if(recordno !=-1){
        		sql.append(" and record_no = ? ");
        	}
        	if(date != null){
        		sql.append(" and rep_stime = ?");
        	}
        	
			st = con.prepareStatement(sql.toString());
			int index=1;
			if(date!=null)
				st.setTimestamp(index++,date);
			if(recordno !=-1){
				st.setInt(index++,recordno);
			}
			
			
			rs = st.executeQuery();
			
			while(rs.next())
			{
				result=rs.getInt(1);
			}
			//Return boolean value to make sure the information has been successfully queried.
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(rs, st, con);
		}
        return result;
	}
	public ArrayList<EmmsBalence> queryaUser( java.sql.Timestamp date ,int recordno,int start,int size)
	{
		ArrayList<EmmsBalence> result = new ArrayList<EmmsBalence>();
		Connection con = null;
		PreparedStatement st = null;
        ResultSet rs = null;
        
        con = DBUtil.getConnection();
        try {
        	StringBuilder sql = new StringBuilder();
        	sql.append(" select * from emms_balance where 1=1 ");
        	if(recordno !=-1){
        		sql.append(" and record_no = ? ");
        	}
        	if(date != null){
        		sql.append(" and rep_stime = ?");
        	}
        	sql.append(" limit ?, ?");
			st = con.prepareStatement(sql.toString());
			int index=1;
			if(date!=null)
				st.setTimestamp(index++,date);
			if(recordno !=-1){
				st.setInt(index++,recordno);
			}
			
			st.setInt(index++, start);
			st.setInt(index++, size);
			rs = st.executeQuery();
			
			while(rs.next())
			{
				EmmsBalence user = new EmmsBalence();
				user.setUserno(rs.getInt("user_no"));
				user.setName(rs.getString("user_addr"));
				user.setCom(rs.getString("user_com"));
				user.setContact(rs.getString("user_contact"));
				user.setGroup(rs.getString("user_group"));
				user.setId(rs.getString("user_id"));
				user.setName(rs.getString("user_name"));
				user.setPhone(rs.getString("user_phone"));
				user.setTel(rs.getString("user_tel"));
				user.setRepno(rs.getInt("rep_no"));
				//user.setEtime(rs.getTimestamp("rep_etime"));
				user.setPrice(rs.getFloat("rep_price"));
				user.setStatus(rs.getString("rep_status"));
				//user.setStime(rs.getTimestamp("rep_stime"));
				user.setEqtno(rs.getInt("eqt_no"));
				user.setType(rs.getString("eqt_type"));
				user.setBrand(rs.getString("eqt_brand"));
				user.setModel(rs.getString("eqt_model"));
				user.setSeriesnumber(rs.getString("eqt_seriesnumber"));
				user.setRecordno(rs.getInt("record_no"));
				user.setTime(rs.getTimestamp("record_time"));
				//user.setReptime(rs.getTimestamp("record_reptime"));
				user.setSalary(rs.getFloat("record_salary"));
				user.setPerson(rs.getString("record_person"));
				user.setEngno(rs.getInt("eng_no"));
				user.setMaterialprice(rs.getFloat("record_materialprice"));
				user.setCptno(rs.getInt("cpt_no"));
				user.setSum(rs.getInt("cpt_sum"));
				user.setDbno(rs.getInt("db_no"));
				user.setCprice(rs.getFloat("db_cprice"));
				user.setPromise(rs.getString("record_promise"));
				user.setAttention(rs.getString("record_attention"));
				result.add(user);
			}
			//Return boolean value to make sure the information has been successfully queried.
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(rs, st, con);
		}
        return result;
	}
	
	
	
	public EmmsEqt queryEqt(int eqtno)
	{
		EmmsEqt user = new EmmsEqt();
		Connection con = null;
		PreparedStatement st = null;
        ResultSet rs = null;
        
        con = DBUtil.getConnection();
        try {
        	StringBuilder sql = new StringBuilder();
        	sql.append(" select * from emms_eqt where 1=1 ");
        	if(eqtno !=-1){
        		sql.append(" and eqt_no = ?");
        	}
        	
			st = con.prepareStatement(sql.toString());
			int index=1;
			if(eqtno !=-1){
				st.setInt(index++,eqtno);
			}

	
	
			rs = st.executeQuery();
			
			while(rs.next())
			{
				user.setNo(rs.getInt("eqt_no"));
				user.setType(rs.getString("eqt_type"));
				user.setBrand(rs.getString("eqt_brand"));
				user.setSeriesnumber(rs.getString("eqt_seriesnumber"));
				user.setModel(rs.getString("eqt_model"));
				user.setComponent(rs.getString("eqt_component"));
				user.setFault(rs.getString("eqt_fault"));
				user.setFaulttype(rs.getString("eqt_fault_type"));
				user.setCheck(rs.getString("eqt_check"));
				user.setPassword(rs.getString("eqt_password"));
				user.setInfo(rs.getString("eqt_info"));
				user.setHdd(rs.getString("eqt_hdd"));
				user.setMemory(rs.getString("eqt_memory"));
				user.setPccard(rs.getString("eqt_pccard"));
				user.setAc(rs.getString("eqt_ac"));
				user.setBattery(rs.getString("eqt_battery"));
				user.setCd(rs.getString("eqt_cd"));
				user.setOthers(rs.getString("eqt_others"));
				
			}
			//Return boolean value to make sure the information has been successfully queried.
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(rs, st, con);
		}
        return user;
	}
	
}
