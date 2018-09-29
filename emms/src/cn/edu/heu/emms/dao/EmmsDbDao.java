package cn.edu.heu.emms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.util.ArrayList;




import cn.edu.heu.emms.common.DBUtil;
import cn.edu.heu.emms.javabean.EmmsCpt;
import cn.edu.heu.emms.javabean.EmmsDb;

public class EmmsDbDao {
	
	public boolean addEmmsDb(EmmsDb eda)
	//Add a user's information to database.
	{
		boolean result = true;
		Connection con = null;
		PreparedStatement st = null;
		con = DBUtil.getConnection();
		
		try {
			st = con.prepareStatement(" insert into "+" emms_db(db_cname,db_cmodel,db_cprice,db_csum,db_wsum,db_status) "+" values(?,?,?,?,?,?) ");
			
			st.setString(1, eda.getCname());
			st.setString(2,eda.getCmodel());
			st.setFloat(3,eda.getCprice());
			st.setInt(4,eda.getCsum());
			st.setInt(5, eda.getWsum());
			st.setString(6,eda.getStatus());
			
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
		
		return result;
	}
	
	public boolean deleteEmmsDb(int dbNo)
	//Delete a user's information from database.
	{
		boolean result = true;
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int i=0;
		con = DBUtil.getConnection();
		
		try {
			st = con.prepareStatement(" delete from emms_cpt where db_no =? ; ");
			st.setInt(1,dbNo);
			
			i = i+st.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		con = DBUtil.getConnection();
		
		try {
			st = con.prepareStatement("  delete from emms_db  where db_no=? ");
			st.setInt(1,dbNo);
			i = i+st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(i >= 2) result=true;
		return result;
	}
		
	public boolean UpdateEmmsDb(EmmsDb edc)
	//更新已有备件入库数据
	{
		boolean result = true;
	    Connection con = null;
	    PreparedStatement st = null;
	    
	    con = DBUtil.getConnection();
	    
	    try {
			st = con.prepareStatement(" update emms_db set db_csum=db_csum+? where db_no=? ");
			st.setInt(1, edc.getCsum());
			st.setInt(2, edc.getNo());
			
			
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
	
	
	 public ArrayList<EmmsDb> queryEmmsDb(EmmsDb u,int start,int size)
	   
	   {
		   ArrayList<EmmsDb> result = new ArrayList<EmmsDb>();
		   Connection con = null;
		   PreparedStatement st = null;
		   ResultSet rs = null;
		   
		   con = DBUtil.getConnection();
		   
		   try {
			  
		    StringBuilder sql= new StringBuilder();
		 
			sql.append(" select * from emms_db where 1=1");
			
			if(u.getNo()!= -1)
			{
				sql.append(" and db_no = ? ");
			}
			sql.append(" limit ?,?");
			st = con.prepareStatement(sql.toString());
			int index=1;
			if(u.getNo()!= -1)
			{
				st.setInt(index++, u.getNo());
			}
		    st.setInt(index++, start);
		    st.setInt(index++, size);
			   //st.setInt(1, u.getNo());
			//st.setInt(2, start);
			//st.setInt(3, size);
			rs = st.executeQuery();
			
			while(rs.next())
			{
				EmmsDb user = new EmmsDb();
				user.setNo(rs.getInt("db_no"));
				user.setCname(rs.getString("db_cname"));
				user.setCmodel(rs.getString("db_cmodel"));
				user.setCprice(rs.getFloat("db_cprice"));
				user.setCsum(rs.getInt("db_csum"));
				user.setWsum(rs.getInt("db_wsum"));
				user.setStatus(rs.getString("db_status"));
				result.add(user);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		   finally 
		   {
			   DBUtil.closeResource(rs,st, con);
		   }
		   
		   return result;
	   }
	  
	
	public ArrayList<EmmsDb> queryCname()
	{
		ArrayList<EmmsDb> result = new ArrayList<EmmsDb>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		con = DBUtil.getConnection();
		
		try {
			st = con.prepareStatement(" select db_no,db_cname,db_cmodel from emms_db ");
			
			rs = st.executeQuery();
			while(rs.next())
			{
				
				EmmsDb impt = new EmmsDb();
				
				
				impt.setNo(rs.getInt("db_no"));
				impt.setCname(rs.getString("db_cname"));
				impt.setCmodel(rs.getString("db_cmodel"));
				result.add(impt);
		
				
			}
			 
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			DBUtil.closeResource(rs,st,con);
		}
		
		
		return result;
	}
	
	
	
	public EmmsDb queryNoCpt(EmmsDb u)
	//通过db_no查询db表后返回cname,cmodel给servlet
	{
		EmmsDb result = new EmmsDb();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		con = DBUtil.getConnection();
		
		try {
			st = con.prepareStatement(" select db_cname,db_cmodel from emms_db where db_no=? ");
			st.setInt(1,u.getNo());
			rs = st.executeQuery();
			while(rs.next())
			{
				
				
				
				
				
				result.setCname(rs.getString("db_cname"));
				result.setCmodel(rs.getString("db_cmodel"));
				
				
			}
			 
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			DBUtil.closeResource(rs,st,con);
		}
		
		
		return result;
	}
	
	
	
	public int queryCsum(EmmsDb u)
	{
		   int result = 0;
		   Connection con = null;
		   PreparedStatement st = null;
		   ResultSet rs = null;
		   con = DBUtil.getConnection();
		   
		   
		   try {
			st = con.prepareStatement(" select db_csum from emms_db where db_no=? ");
			st.setInt(1, u.getNo());
			rs = st.executeQuery();
		   
			rs.next();
			result=rs.getInt("db_csum");
			
			
			
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   finally
			{
				DBUtil.closeResource(rs,st,con);
			}
			
		return result;
		
	}
	
	public int queryEmmsDbTotalRows(EmmsDb u)
	   
	   {
		   int result = 0;
		   Connection con = null;
		   PreparedStatement st = null;
		   ResultSet rs = null;
		   
		   con = DBUtil.getConnection();
		   
		   try {
		      StringBuilder sql = new StringBuilder();
		     
			sql.append(" select count(*) from emms_db where 1=1");
			//st = con.prepareStatement(" select count(*) from emms_db where db_no = ?");
			if(u.getNo()!=-1)
			{
				sql.append(" and db_no = ?");
			
				
				
			}
			st = con.prepareStatement(sql.toString());
			
			
			if(u.getNo()!=-1)
			{
				
			
				st.setInt(1, u.getNo());
				
			}
			
			rs = st.executeQuery();
			
		 if(rs.next())
		 {
			 result = rs.getInt(1);
		 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		   finally 
		   {
			   DBUtil.closeResource(rs,st, con);
		   }
		   
		   return result;
	   }

	public boolean InsertCpt(EmmsCpt ic)
	{
		boolean result = true;
		Connection con = null;
		   PreparedStatement st = null;
		   ResultSet rs = null;
		   
		   con = DBUtil.getConnection();
		   
		   try {
			st = con.prepareStatement(" insert into "+" emms_cpt(cpt_name,cpt_model,cpt_sum,record_no,db_no) "+" values(?,?,?,?,?) ");
			st.setString(1, ic.getName());
			st.setString(2,ic.getModel());
			st.setInt(3,ic.getSum());
			st.setInt(4,ic.getRecordno());
			st.setInt(5, ic.getDb());
			
			int i = st.executeUpdate();
			if(i<1)
			{
				result = false;
			}
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
		}

		return result;
	}
	
	
	public boolean UpdateImEmmsDb(EmmsDb a)
	//更新已有备件出库数据
	{
		boolean result = true;
	    Connection con = null;
	    PreparedStatement st = null;
	    
	    con = DBUtil.getConnection();
	    
	    try {
			st = con.prepareStatement(" update emms_db set db_csum=db_csum-? where db_no=? ");
			st.setInt(1, a.getCsum());
			st.setInt(2, a.getNo());
			
			
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
	
	
	
	

}
