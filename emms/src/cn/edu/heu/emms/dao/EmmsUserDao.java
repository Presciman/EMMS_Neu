package cn.edu.heu.emms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.heu.emms.common.DBUtil;
import cn.edu.heu.emms.javabean.EmmsUser;



public class EmmsUserDao {
	public boolean addEmmsUser(EmmsUser user)
	//Add a user's information to database.
	{
		boolean result = true;
		Connection con = null;
		PreparedStatement st = null;
		con = DBUtil.getConnection();
		
		if(user.getNo()==0)
		{
			return false;
		}
		
		try {
			st = con.prepareStatement(" insert into "+" emms_user(user_name,user_id,user_group,user_com,user_tel,user_phone,user_addr,user_post,user_contact,user_email) "+" values(?,?,?,?,?,?,?,?,?,?) ");
			st.setString(1, user.getName());
			st.setString(2, user.getId());
			st.setString(3,user.getGroup());
			st.setString(4,user.getCom());
			st.setString(5,user.getTel());
			st.setString(6, user.getPhone());
			st.setString(7,user.getAddr());
			st.setString(8, user.getPost());
			st.setString(9,user.getContact());
			st.setString(10, user.getEmail());
			System.out.println(user.getEmail());
			int i = st.executeUpdate();
			if(i<1)
			{
				result = false;
			}
			//Return boolean value to make sure the information has been successfully inserted.
		} catch (SQLException e) {
			result = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBUtil.closeResource(st, con);
		}
		return result;
	}
	
	public boolean deleteEmmsUser(int eu)
	//Delete a user's information from database.
	{
		boolean result = true;
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		con = DBUtil.getConnection();
		
		try {
			st = con.prepareStatement(" delete from emms_user  where user_no=? ");
			st.setInt(1,eu);
			int i = st.executeUpdate();
			   if(i<1)
			   {
				   result = false;
			   }
			
			
		} catch (SQLException e) {
			result = false;
			
			e.printStackTrace();
		}
		return result;
	}
		
	public boolean UpdateEmmsUser(EmmsUser ueu)
	//Update a user's all column from database.
	{
		boolean result = false;
	    Connection con = null;
	    PreparedStatement st = null;
	    
	    con = DBUtil.getConnection();
	    
	    try {
			st = con.prepareStatement(" update emms_user set user_name=?,user_id=?,user_group=?,user_com=?,user_tel=?,user_phone=?,user_addr=?,user_post=?,user_contact=?,user_email=?   where user_no=?");
			st.setString(1,ueu.getName());
			st.setString(2,ueu.getId());
			st.setString(3, ueu.getGroup());
			st.setString(4,ueu.getCom());
			st.setString(5, ueu.getTel());
			st.setString(6,ueu.getPhone());
			st.setString(7,ueu.getAddr());
			st.setString(8,ueu.getPost());
			st.setString(9, ueu.getContact());
			st.setString(10,ueu.getEmail());
			st.setInt(11, ueu.getNo());
			
			int i = st.executeUpdate();
			   if(i==1)
			   {
				   result = true;
			   }
			
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
	    finally{
			DBUtil.closeResource(st, con);
		}
		
		return result;
	}
	
	public boolean queryEmmsUser(EmmsUser u)
	//Query a user's information from database.
	{
		boolean result = false;
		Connection con = null;
		PreparedStatement st = null;
        ResultSet rs = null;
        
        con = DBUtil.getConnection();
        
        try {
			st = con.prepareStatement(" select count(*) as c from emms_user where user_no=? ");
			st.setInt(1,u.getNo());
			
			rs = st.executeQuery();
			
			if(rs.next())
			{
				int i = rs.getInt("c");
				  if(i==1)
				  {
					  result = true;
				  }
			}
			//Return boolean value to make sure the information has been successfully queried.
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(rs, st, con);
		}
		
		return result;
		
	}
	
	
	
	public int queryUserTotalRows(EmmsUser u)
	{
		int result = 0;
		Connection con = null;
		PreparedStatement st = null;
        ResultSet rs = null;
        
        con = DBUtil.getConnection();
        try {
			st = con.prepareStatement(" select count(*) as c from emms_user where user_no=? ");
			st.setInt(1,u.getNo());
			
			rs = st.executeQuery();
			
			if(rs.next())
			{
				result = rs.getInt(1);
			}
			//Return boolean value to make sure the information has been successfully queried.
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(rs, st, con);
		}
        return result;
	}
	public int queryUserTotalRows(int userno)
	{
		int result = 0;
		Connection con = null;
		PreparedStatement st = null;
        ResultSet rs = null;
        
        con = DBUtil.getConnection();
        try {
        	StringBuilder sql = new StringBuilder();
        	sql.append(" select count(*) as c from emms_user");
        	if(userno != -1){
        		sql.append(" where user_no = ?");
        	}
			st = con.prepareStatement(sql.toString());

			if(userno != -1){
				st.setInt(1, userno);
			}
			rs = st.executeQuery();
			
			if(rs.next())
			{
				result = rs.getInt(1);
			}
			//Return boolean value to make sure the information has been successfully queried.
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(rs, st, con);
		}
        return result;
	}
	
	public ArrayList<EmmsUser> queryUser(int userno,int start,int size)
	{
		ArrayList<EmmsUser>result = new ArrayList<EmmsUser>();
		Connection con = null;
		PreparedStatement st = null;
        ResultSet rs = null;
        
        con = DBUtil.getConnection();
        try {
        	StringBuilder sql = new StringBuilder();
        	sql.append(" select * from emms_user ");
        	if(userno != -1){
        		sql.append(" where user_no = ?");
        	}
        	sql.append(" limit ?,?");
        	
			st = con.prepareStatement(sql.toString());
			int index = 1;
			if(userno != -1){
				st.setInt(index++, userno);
			}
			st.setInt(index++, start);
			st.setInt(index++, size);
			rs = st.executeQuery();
			
			while(rs.next())
			{
				EmmsUser user = new EmmsUser();
				user.setNo(rs.getInt("user_no"));
				user.setName(rs.getString("user_name"));
				user.setId(rs.getString("user_id"));
				user.setGroup(rs.getString("user_group"));
				user.setCom(rs.getString("user_com"));
				user.setTel(rs.getString("user_tel"));
				user.setPhone(rs.getString("user_phone"));
				user.setAddr(rs.getString("user_addr"));
				user.setPost(rs.getString("user_post"));
				user.setContact(rs.getString("user_contact"));
				user.setEmail(rs.getString("user_email"));
				
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
	public ArrayList<EmmsUser> queryUser(int uno)
	{
		ArrayList<EmmsUser>result = new ArrayList<EmmsUser>();
		Connection con = null;
		PreparedStatement st = null;
        ResultSet rs = null;
        
        con = DBUtil.getConnection();
        try {
        	StringBuilder sql = new StringBuilder();
        	sql.append(" select user_no,user_name from emms_user where 1=1 ");
        	if(uno !=-1){
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
				EmmsUser user = new EmmsUser();

				user.setName(rs.getString("user_name"));
				user.setNo(rs.getInt("user_no"));
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
	public EmmsUser queryaUser(int uno)
	{
		EmmsUser user = new EmmsUser();
		Connection con = null;
		PreparedStatement st = null;
        ResultSet rs = null;
        
        con = DBUtil.getConnection();
        try {
        	StringBuilder sql = new StringBuilder();
        	sql.append(" select * from emms_user where 1=1 ");
        	if(uno !=-1){
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
				user.setNo(rs.getInt("user_no"));
				user.setName(rs.getString("user_name"));
				user.setId(rs.getString("user_id"));
				user.setGroup(rs.getString("user_group"));
				user.setCom(rs.getString("user_com"));
				user.setTel(rs.getString("user_tel"));
				user.setPhone(rs.getString("user_phone"));
				user.setAddr(rs.getString("user_addr"));
				user.setPost(rs.getString("user_post"));
				user.setContact(rs.getString("user_contact"));
				user.setEmail(rs.getString("user_email"));
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
