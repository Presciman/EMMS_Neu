package cn.edu.heu.emms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.heu.emms.common.DBUtil;
import cn.edu.heu.emms.javabean.EmmsEng;
import cn.edu.heu.emms.javabean.EmmsMyRecord;
import cn.edu.heu.emms.javabean.EmmsMyTask;
import cn.edu.heu.emms.javabean.EmmsRecord;
import cn.edu.heu.emms.javabean.EmmsTasking;


public class EmmsTaskDao {
	 //查询所有信息
    public ArrayList<EmmsTasking> queryTasking (int start, int size){
  	 
    	ArrayList<EmmsTasking> result = new ArrayList<EmmsTasking>();
  	  
  	   Connection con = null;
  	   PreparedStatement st = null;
  	   ResultSet rs = null;
  	   
  	   con = DBUtil.getConnection();
  	   
  	   try {
  		 //***
  		   
  		  StringBuilder sql=new StringBuilder();
  		
  		  sql.append(" select * from tasking");
  		 
  		  sql.append(" limit ?,? ");
  		  
			st = con.prepareStatement(sql.toString());
			//**
			
 		  st.setInt(1,start);
 		  st.setInt(2,size);
 		  
 		  rs = st.executeQuery();
			while(rs.next())
			{
				EmmsTasking task = new EmmsTasking();
				task.setRepno(rs.getInt("rep_no"));
				task.setStime(rs.getDate("rep_stime"));
				task.setType(rs.getString("eqt_type"));
				task.setRepstatus(rs.getString("rep_status"));
				task.setRecordstatus(rs.getString("record_status"));
				
				result.add(task);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(rs, st, con);
		}
  	   
  	  return result;
    }
    
    
    
    //查询一条信息
    public EmmsMyRecord queryMyRecord (int recordno){
  	 
    	EmmsMyRecord task = new EmmsMyRecord();
  	  
  	   Connection con = null;
  	   PreparedStatement st = null;
  	   ResultSet rs = null;
  	   
  	   con = DBUtil.getConnection();
  	   
  	   try {
  		 //***
  		   
  		  StringBuilder sql=new StringBuilder();
  		
  		  sql.append(" select * from  myeqtrecord where record_no = ? ");
  		 
  		
			st = con.prepareStatement(sql.toString());
			//**
			
 		  st.setInt(1,recordno);
 		 
 		  
 		  rs = st.executeQuery();
			rs.next();
		
				
				//task.setRepno(rs.getInt("rep_no"));
				task.setRecordno(rs.getInt("record_no"));
				task.setRecordtime(rs.getDate("record_time"));
				task.setType(rs.getString("eqt_type"));
				task.setBrand(rs.getString("eqt_brand"));
				task.setModel(rs.getString("eqt_model"));
				task.setSeriesnumber(rs.getString("eqt_seriesnumber"));
				task.setEngno(rs.getInt("eng_no"));
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(rs, st, con);
		}
  	   
  	  return task;
    }
    
    //查询个人任务
    public ArrayList<EmmsMyTask> queryMyTask (int engno ,int start, int size){
     	 
    	ArrayList<EmmsMyTask> result = new ArrayList<EmmsMyTask>();
  	  
  	   Connection con = null;
  	   PreparedStatement st = null;
  	   ResultSet rs = null;
  	   
  	   con = DBUtil.getConnection();
  	   
  	   try {
  		 //***
  		   
  		  StringBuilder sql=new StringBuilder();
  		
  		  sql.append(" select * from mytask where eng_no = ? ");
  		 
  		  sql.append(" limit ?,? ");
  		  
			st = con.prepareStatement(sql.toString());
			//**
		  st.setInt(1,engno);
 		  st.setInt(2,start);
 		  st.setInt(3,size);
 		  
 		  rs = st.executeQuery();
			while(rs.next())
			{
				EmmsMyTask task = new EmmsMyTask();
				task.setRecordno(rs.getInt("record_no"));
		//		task.setEtime(rs.getDate("rep_etime"));
				task.setType(rs.getString("eqt_type"));
				task.setEngno(rs.getInt("eng_no"));
				task.setRecordtime(rs.getDate("record_time"));
				task.setRecordstatus(rs.getString("record_status"));
				
				result.add(task);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(rs, st, con);
		}
  	   
  	  return result;
    }
    
  //查询个人进行中任务
    public ArrayList<EmmsMyTask> queryMyTasking (int engno ,int start, int size){
     	 
    	ArrayList<EmmsMyTask> result = new ArrayList<EmmsMyTask>();
  	  
  	   Connection con = null;
  	   PreparedStatement st = null;
  	   ResultSet rs = null;
  	   
  	   con = DBUtil.getConnection();
  	   
  	   try {
  		 //***
  		   
  		  StringBuilder sql=new StringBuilder();
  		
  		  sql.append(" select * from mytasking where eng_no = ? ");
  		 
  		  sql.append(" limit ?,? ");
  		  
			st = con.prepareStatement(sql.toString());
			//**
		  st.setInt(1,engno);
 		  st.setInt(2,start);
 		  st.setInt(3,size);
 		  
 		  rs = st.executeQuery();
			while(rs.next())
			{
				EmmsMyTask task = new EmmsMyTask();
				task.setRecordno(rs.getInt("record_no"));
			//	task.setEtime(rs.getDate("rep_etime"));
				task.setRecordtime(rs.getDate("record_time"));
				task.setType(rs.getString("eqt_type"));
				task.setEngno(rs.getInt("eng_no"));
				task.setRecordstatus(rs.getString("record_status"));
				task.setEqtno(rs.getInt("eqt_no"));
				result.add(task);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(rs, st, con);
		}
  	   
  	  return result;
    }
    
  //查询总量
    public int queryTaskTotalrows(){
  	   int  result = 0;
  	  
  	   Connection con = null;
  	   PreparedStatement st = null;
  	   ResultSet rs = null;
  	   
  	   con = DBUtil.getConnection();
  	   System.out.println(con);
  	   try {
  		 //***
  		   
  		 
  		 st=con.prepareStatement(" select count(*) as c from tasking ");
  		 
 		  rs = st.executeQuery();
			if(rs.next())
			{
				//result = rs.getInt(1);
				result = rs.getInt("c");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(rs, st, con);
		}
  	   
  	  return result;
    }
    
    
    //查询个人总量
    public int queryMyTaskTotalrows(){
  	   int  result = 0;
  	  
  	   Connection con = null;
  	   PreparedStatement st = null;
  	   ResultSet rs = null;
  	   
  	   con = DBUtil.getConnection();
  	   System.out.println(con);
  	   try {
  		 //***
  		   
  		 
  		 st=con.prepareStatement(" select count(*) as c from mytask ");
  		 
 		  rs = st.executeQuery();
			if(rs.next())
			{
				//result = rs.getInt(1);
				result = rs.getInt("c");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(rs, st, con);
		}
  	   
  	  return result;
    }
    
    
    //查询个人进行中总量
    public int queryMyTaskingTotalrows(){
  	   int  result = 0;
  	  
  	   Connection con = null;
  	   PreparedStatement st = null;
  	   ResultSet rs = null;
  	   
  	   con = DBUtil.getConnection();
  	   System.out.println(con);
  	   try {
  		 //***
  		   
  		 
  		 st=con.prepareStatement(" select count(*) as c from mytasking ");
  		 
 		  rs = st.executeQuery();
			if(rs.next())
			{
				//result = rs.getInt(1);
				result = rs.getInt("c");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(rs, st, con);
		}
  	   
  	  return result;
    }
    
  //查询所有工程师信息
    public ArrayList<EmmsEng> queryEng (){
  	 
    	ArrayList<EmmsEng> result = new ArrayList<EmmsEng>();
  	  
  	   Connection con = null;
  	   PreparedStatement st = null;
  	   ResultSet rs = null;
  	   
  	   con = DBUtil.getConnection();
  	   
  	   try {
  		 //***
  		   
  		  StringBuilder sql=new StringBuilder();
  		
  		  sql.append(" select * from  emms_engineer");
  		 
  		 
  		  
		 st = con.prepareStatement(sql.toString());
			//**
 		  rs = st.executeQuery();
 		  
			while(rs.next())
			{
				EmmsEng eng = new EmmsEng();
				eng.setEngno(rs.getInt("eng_no"));
				eng.setEngname(rs.getString("eng_name"));
				eng.setEngtask(rs.getInt("eng_tasking"));
				
				result.add(eng);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(rs, st, con);
		}
  	   
  	  return result;
    }
    
  //匹配任务
    public boolean  taskUpdate(int repno, int engno, String engname){
  	 
    	boolean result = false;
  	  
  	   Connection con = null;
  	   PreparedStatement st = null;
  	   ResultSet rs = null;
  	   
  	   con = DBUtil.getConnection();
  	   
  	   try {
  		 //***
  		 st = con.prepareStatement(" update emms_record set "
  		 		+ " record_person = ?, eng_no = ? , record_status = '分配未维修',record_time = CURDATE() "
  		 		+ " where rep_no = ? ");

			st.setString(1, engname );  		 
			st.setInt(2,engno);
			st.setInt(3,repno);
			
			int i = st.executeUpdate();
			System.out.println(i);
			if(i < 1)
			{
				result = false;
			}else
				if(i >= 1)
					result = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(st, con);
		}
  	   
  	  return result;
    }
    
    
  //添加开始维修的任务
    public boolean  addMyTask(int recordno){
  	 
    	boolean result = false;
  	  
  	   Connection con = null;
  	   PreparedStatement st = null;
  	   ResultSet rs = null;
  	   
  	   con = DBUtil.getConnection();
  	   
  	   try {
  		 //***
  		 st = con.prepareStatement(" update emms_record set "
  		 		+ " record_status = '维修中' "
  		 		+ " where record_no = ? ");
         
			
			st.setInt(1,recordno);
			
			int i = st.executeUpdate();
			if(i != 1)
			{
				result = false;
			}else
				if(i == 1)
					result = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(st, con);
		}
  	   
  	  return result;
    }
    
    
    //编辑维修记录
    public boolean  editTaskRecord(EmmsRecord record){
  	 
    	boolean result = false;
  	  
  	   Connection con = null;
  	   PreparedStatement st = null;
  	   ResultSet rs = null;
  	   
  	   con = DBUtil.getConnection();
  	   
  	   try {
  		
			
  		StringBuilder sql = new StringBuilder();
		  sql.append(" update emms_record set ");
		  		
		  if(record.getNo()!=0)
		  {
			  sql.append(" record_no = ? ");
				
		  }
		  if(record.getReptime()!= null)
		  {
			  sql.append(" ,record_reptime = ? ");
		  }
		  
		  if(!record.getCheckout().equals(""))
		  {
			  sql.append(" ,record_checkout = ? ");
		  }
		  
		  if(!record.getRepairment().equals(""))
		  {
			  sql.append(" ,record_repairment = ? ");
				
		  }
		  
		  if(!record.getWork().equals(""))
		  {
			  sql.append(" ,record_work = ? ");
				
		  }
		  
		  if(record.getSalary()!=0)
		  {
			  sql.append(" ,record_salary = ? ");
				
		  }
		  
		  if(record.getMaterialprice() != 0)
		  {
			  sql.append(" ,record_materialprice = ? ");
				
		  }
		  
		  if(! record.getDelay().equals(""))
		  {
			  sql.append(" ,record_delay = ? ");
				
		  }
		  
		  if(! record.getPromise().equals(""))
		  {
			  sql.append(" ,record_promise = ? ");
				
		  }
		  
		  if(! record.getAttention().equals(""))
		  {
			  sql.append(" ,record_attention = ? ");
				
		  }
		 
		  
		  sql.append(" where record_no = ? ");
		  
		  st = con.prepareStatement(sql.toString());
		  System.out.println(st);
		  int index = 1;
		  
		  if(record.getNo()!=0)
		  {
			  st.setInt(index++, record.getNo());
				
		  }
		  if(record.getReptime()!=null)
		  {
			  java.sql.Date reptime = new java.sql.Date(record.getReptime().getTime());
			  st.setDate(index++, reptime);
		  }
		  
		  if(!record.getCheckout().equals(""))
		  {
			  st.setString(index++, record.getCheckout());
		  }
		  
		  if(!record.getRepairment().equals(""))
		  {
			  st.setString(index++, record.getRepairment());
				
		  }
		  
		  if(!record.getWork().equals(""))
		  {
			  st.setString(index++, record.getWork());
				
		  }
		  
		  if(record.getSalary()!=0)
		  {
			  st.setFloat(index++, record.getSalary());
				
		  }
		  
		  if(record.getMaterialprice() != 0)
		  {
			  st.setFloat(index++, record.getMaterialprice());
				
		  }
		  
		  if(! record.getDelay().equals(""))
		  {
			  st.setString(index++, record.getDelay());
				
		  }
		  
		  if(! record.getPromise().equals(""))
		  {
			  st.setString(index++,record.getPromise());
				
		  }
		  
		  if(! record.getAttention().equals(""))
		  {
			  st.setString(index++,record.getAttention());
				
		  }
		  
		  
		  st.setInt(index++,record.getNo());
		         
		  
			int i = st.executeUpdate();
			if(i != 1)
			{
				result = false;
			}else
				if(i == 1)
					result = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(st, con);
		}
  	   
  	  return result;
    }
    
  //提交任务
    public boolean  finishTask(int recordno){
  	 
    	boolean result = false;
  	  
  	   Connection con = null;
  	   PreparedStatement st = null;
  	   ResultSet rs = null;
  	   
  	   con = DBUtil.getConnection();
  	   
  	   try {
  		 //***
  		 st = con.prepareStatement(" update emms_record set "
  		 		+ " record_status = '维修完成' "
  		 		+ " where record_no = ? ");
         
			
			st.setInt(1,recordno);
			
			int i = st.executeUpdate();
			if(i != 1)
			{
				result = false;
			}else
				if(i == 1)
					result = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(st, con);
		}
  	   
  	  return result;
    }
    
}
