package cn.edu.heu.emms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.heu.emms.common.DBUtil;
import cn.edu.heu.emms.javabean.EmmsLogin;



public class EmmsLoginDao {
	//µÇÂ½
    public int login(EmmsLogin u){
  	  int  result = -1;
  	  boolean state = false;
  	  Connection con = null;
  	  PreparedStatement st = null;
  	  ResultSet rs = null;
  	  
  	  con = DBUtil.getConnection();
  	  
  	  try {
			st = con.prepareStatement("select count(*) as c from login_info "
			  		+ " where loginer_name = ? and loginer_password= ?");
			
			st.setString(1,u.getLoginer());
			st.setString(2, u.getPassword());
			
			rs = st.executeQuery();
			
			if (rs.next())
			{
				int i = rs.getInt("c");
				if(i==1)
				{
					state = true;
				}
			}				
			
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//  	  
//  	  
//  	try {
		st = con.prepareStatement("select loginer_grant as g from login_info "
		  		+ " where loginer_name = ? and loginer_password = ?");
		st.setString(1,u.getLoginer());
		st.setString(2, u.getPassword());
		
		rs = st.executeQuery();
		
		if(state==true){
			rs.next();
			int r = rs.getInt("g");
			if(r<=6&&r>=0){
				 result = r;
			}
			
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}finally{
		DBUtil.closeResource(rs,st,con);
	}
  	  
  	  return result;
    }
    
  //²éÑ¯±àºÅ
    public int loginNo(EmmsLogin u){
  	  int  result = -1;
  	
  	  Connection con = null;
  	  PreparedStatement st = null;
  	  ResultSet rs = null;
  	  
  	  con = DBUtil.getConnection();
  	 try {
  		st = con.prepareStatement("select loginer_no as no from login_info "
		  		+ " where loginer_name = ? ");
		st.setString(1,u.getLoginer());
		
		rs = st.executeQuery();
		
		
			rs.next();
			int r = rs.getInt("no");
		    result = r;
			
	} catch (SQLException e) {
		
		e.printStackTrace();
	}finally{
		DBUtil.closeResource(rs,st,con);
	}
  	  
  	  return result;
    }
  	 
  	  
}
