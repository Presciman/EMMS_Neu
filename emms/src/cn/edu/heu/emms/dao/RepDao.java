package cn.edu.heu.emms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import cn.edu.heu.emms.common.DBUtil;
import cn.edu.heu.emms.javabean.CommitRep;
import cn.edu.heu.emms.javabean.EmmsRep;
import cn.edu.heu.emms.javabean.EmmsEqt;

public class RepDao {

	//����û����޼�¼���������豸
	public boolean AddRep(EmmsRep rep,EmmsEqt eqt){
		int i=0;
		
		boolean result = false;
		Connection con = null;
		PreparedStatement st =null;
	
		//����eqt����Ϣ��
		con=DBUtil.getConnection();
		try {
			st=con.prepareStatement("insert into emms_eqt values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			st.setInt(1, eqt.getNo());
			st.setString(2, eqt.getType());
			st.setString(3, eqt.getBrand());
			st.setString(4, eqt.getSeriesnumber());
			st.setString(5, eqt.getModel());
			st.setString(6, eqt.getComponent());
			st.setString(7, eqt.getFault());
			st.setString(8, eqt.getFaulttype());
			st.setString(9, eqt.getCheck());
			st.setString(10, eqt.getPassword());
			st.setString(11, eqt.getInfo());
			st.setString(12, eqt.getHdd());
			st.setString(13, eqt.getMemory());
			st.setString(14, eqt.getPccard());
			st.setString(15, eqt.getAc());
			st.setString(16, eqt.getBattery());
			st.setString(17, eqt.getCd());
			st.setString(18, eqt.getOthers());
			i =i+ st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(st, con);
		}
		//����rep����Ϣ��
		con=DBUtil.getConnection();
		try {
			st=con.prepareStatement("insert into emms_rep(rep_stime,rep_price,rep_status,user_no,eqt_no) values(?,?,?,?,?)");
			st.setTimestamp(1, new java.sql.Timestamp(rep.getStime().getTime()));
			st.setFloat(2, rep.getPrice());
			st.setString(3, rep.getStatus());
			st.setInt(4, rep.getUserno());
			st.setInt(5, rep.getEqtno());
			i =i+ st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(st, con);
		}
		
		if(i == 2){
			result=true;
		}
		
		return result;
	}
	
	//��userno��ѯ���޼�¼
	public ArrayList<CommitRep> CommitRep(int userno){
		ArrayList<CommitRep> result = new ArrayList<CommitRep>();
		Connection con = null;
		PreparedStatement st =null;
		ResultSet rs =null;
		
		con=DBUtil.getConnection();
		try {
			st=con.prepareStatement("select * from commitrep where user_no = ?");
			st.setInt(1, userno);
			rs=st.executeQuery();
			while(rs.next()){
				CommitRep rep = new CommitRep();
				rep.setUser_no(rs.getInt("user_no"));
				rep.setUser_name(rs.getString("user_name"));
				rep.setUser_addr(rs.getString("user_addr"));
				rep.setUser_com(rs.getString("user_com"));
				rep.setUser_contact(rs.getString("user_contact"));
				rep.setUser_phone(rs.getString("user_phone"));
				
				rep.setEqt_brand(rs.getString("eqt_brand"));
				rep.setEqt_component(rs.getString("eqt_component"));
				rep.setEqt_model(rs.getString("eqt_model"));
				rep.setEqt_no(rs.getInt("eqt_no"));
				rep.setEqt_seriesnumber(rs.getString("eqt_seriesnumber"));
				rep.setEqt_type(rs.getString("eqt_type"));
				
				//rep.setRep_etime(rs.getTimestamp("rep_etime"));
				rep.setRep_price(rs.getFloat("rep_price"));
				rep.setRep_status(rs.getString("rep_status"));
				rep.setRep_stime(rs.getTimestamp("rep_stime"));
				result.add(rep);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(rs, st, con);
		}
	
		return result;
	}
	//��eqtno��ѯ���޼�¼
		public ArrayList<CommitRep> CommitRepByeqtno(int eqtno){
			ArrayList<CommitRep> result = new ArrayList<CommitRep>();
			Connection con = null;
			PreparedStatement st =null;
			ResultSet rs =null;
			
			con=DBUtil.getConnection();
			try {
				st=con.prepareStatement("select * from commitrep where eqt_no = ?");
				st.setInt(1, eqtno);
				rs=st.executeQuery();
				while(rs.next()){
					CommitRep rep = new CommitRep();
					rep.setUser_no(rs.getInt("user_no"));
					rep.setUser_name(rs.getString("user_name"));
					rep.setUser_addr(rs.getString("user_addr"));
					rep.setUser_com(rs.getString("user_com"));
					rep.setUser_contact(rs.getString("user_contact"));
					rep.setUser_phone(rs.getString("user_phone"));
					
					rep.setEqt_brand(rs.getString("eqt_brand"));
					rep.setEqt_component(rs.getString("eqt_component"));
					rep.setEqt_model(rs.getString("eqt_model"));
					rep.setEqt_no(rs.getInt("eqt_no"));
					rep.setEqt_seriesnumber(rs.getString("eqt_seriesnumber"));
					rep.setEqt_type(rs.getString("eqt_type"));
					
					
					rep.setRep_price(rs.getFloat("rep_price"));
					rep.setRep_status(rs.getString("rep_status"));
					rep.setRep_stime(rs.getTimestamp("rep_stime"));
					result.add(rep);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.closeResource(rs, st, con);
			}
			//����ά�޼�¼��Ϣ
			con=DBUtil.getConnection();
			try {
				st=con.prepareStatement("insert into emms_record(record_status,rep_no) values('δ����',(select rep_no from emms_rep where eqt_no =?))");
				st.setInt(1, eqtno);
				st.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.closeResource(st, con);
			}
			return result;
		}
		public ArrayList<CommitRep> CommitRepByTimedeng(int eqtno,String eqttype,Timestamp stime){
			ArrayList<CommitRep> result = new ArrayList<CommitRep>();
			Connection con = null;
			PreparedStatement st =null;
			ResultSet rs =null;
			
			con=DBUtil.getConnection();
			try {
				StringBuilder sql=new StringBuilder();
				sql.append("select * from commitrep where rep_stime = ? and eqt_type = ? ");
				if(eqtno != -1){
					sql.append(" and eqt_no = ?");
				}
				st=con.prepareStatement(sql.toString());
				
				st.setTimestamp(1, stime);
				st.setString(2, eqttype);
				if(eqtno != -1){
					st.setInt(3, eqtno);
				}
				rs=st.executeQuery();
				while(rs.next()){
					CommitRep rep = new CommitRep();
					rep.setUser_no(rs.getInt("user_no"));
					rep.setUser_name(rs.getString("user_name"));
					rep.setUser_addr(rs.getString("user_addr"));
					rep.setUser_com(rs.getString("user_com"));
					rep.setUser_contact(rs.getString("user_contact"));
					rep.setUser_phone(rs.getString("user_phone"));
					
					rep.setEqt_brand(rs.getString("eqt_brand"));
					rep.setEqt_component(rs.getString("eqt_component"));
					rep.setEqt_model(rs.getString("eqt_model"));
					rep.setEqt_no(rs.getInt("eqt_no"));
					rep.setEqt_seriesnumber(rs.getString("eqt_seriesnumber"));
					rep.setEqt_type(rs.getString("eqt_type"));
					
					//rep.setRep_etime(rs.getTimestamp("rep_etime"));
					rep.setRep_price(rs.getFloat("rep_price"));
					rep.setRep_status(rs.getString("rep_status"));
					rep.setRep_stime(rs.getTimestamp("rep_stime"));
					result.add(rep);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.closeResource(rs, st, con);
			}
		
			return result;
		}
		public ArrayList<CommitRep> QueryRepAll(int start,int size){
			ArrayList<CommitRep> result = new ArrayList<CommitRep>();
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs =null;
			
			con=DBUtil.getConnection();
			try {
				st=con.prepareStatement("select * from commitrep limit ?,?;");
				st.setInt(1, start);
				st.setInt(2, size);
				rs=st.executeQuery();
				while(rs.next()){
					CommitRep rep = new CommitRep();
					rep.setUser_no(rs.getInt("user_no"));
					rep.setUser_name(rs.getString("user_name"));
					rep.setUser_addr(rs.getString("user_addr"));
					rep.setUser_com(rs.getString("user_com"));
					rep.setUser_contact(rs.getString("user_contact"));
					rep.setUser_phone(rs.getString("user_phone"));
					
					rep.setEqt_brand(rs.getString("eqt_brand"));
					rep.setEqt_component(rs.getString("eqt_component"));
					rep.setEqt_model(rs.getString("eqt_model"));
					rep.setEqt_no(rs.getInt("eqt_no"));
					rep.setEqt_seriesnumber(rs.getString("eqt_seriesnumber"));
					rep.setEqt_type(rs.getString("eqt_type"));
					
					//rep.setRep_etime(rs.getTimestamp("rep_etime"));
					rep.setRep_price(rs.getFloat("rep_price"));
					rep.setRep_status(rs.getString("rep_status"));
					rep.setRep_stime(rs.getTimestamp("rep_stime"));
					result.add(rep);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.closeResource(rs, st, con);
			}
		
			return result;
		}
		public ArrayList<CommitRep> QueryRepAll(int eqtno,int start,int size){
			ArrayList<CommitRep> result = new ArrayList<CommitRep>();
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs =null;
			StringBuilder sql = new StringBuilder();
			sql.append("select * from commitrep where 1=1 ");
			if(eqtno != -1){
				sql.append(" and eqt_no = ? ");
			}
			sql.append(" limit ?,?;");
			con=DBUtil.getConnection();
			try {
				st=con.prepareStatement(sql.toString());
				int index =1;
				if(eqtno != -1){
					st.setInt(index++, eqtno);}
				st.setInt(index++, start);
				st.setInt(index++, size);
				rs=st.executeQuery();
				while(rs.next()){
					CommitRep rep = new CommitRep();
					rep.setUser_no(rs.getInt("user_no"));
					rep.setUser_name(rs.getString("user_name"));
					rep.setUser_addr(rs.getString("user_addr"));
					rep.setUser_com(rs.getString("user_com"));
					rep.setUser_contact(rs.getString("user_contact"));
					rep.setUser_phone(rs.getString("user_phone"));
					
					rep.setEqt_brand(rs.getString("eqt_brand"));
					rep.setEqt_component(rs.getString("eqt_component"));
					rep.setEqt_model(rs.getString("eqt_model"));
					rep.setEqt_no(rs.getInt("eqt_no"));
					rep.setEqt_seriesnumber(rs.getString("eqt_seriesnumber"));
					rep.setEqt_type(rs.getString("eqt_type"));
					
					//rep.setRep_etime(rs.getTimestamp("rep_etime"));
					rep.setRep_price(rs.getFloat("rep_price"));
					rep.setRep_status(rs.getString("rep_status"));
					rep.setRep_stime(rs.getTimestamp("rep_stime"));
					result.add(rep);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.closeResource(rs, st, con);
			}
		
			return result;
		}
		public int QueryRepAllrows(){
			int result=0;
			Connection con = null;
			Statement st =null;
			ResultSet rs =null;
			
			con=DBUtil.getConnection();
			try {
				st=con.createStatement();
				rs=st.executeQuery("select count(*) from commitrep;");
				while(rs.next()){
					result=rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.closeResource(rs, st, con);
			}
			return result;
		
			
		}
//�ύ����
	public boolean SendRep(int eqtno){
		int i = 0;
		boolean result=false;
		//�������ݿ⣬��rep״̬��Ϊ�����У�ͬʱ����reorde����
		Connection con = DBUtil.getConnection();
		PreparedStatement st = null;
		try {
			st=con.prepareStatement("update commitrep set rep_status='������' where eqt_no =? ");
			st.setInt(1, eqtno);
			i=i+st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(st, con);
		}
//��record���в������ݣ�
		//����ά�޼�¼��Ϣ
				con=DBUtil.getConnection();
				try {
					st=con.prepareStatement("insert into emms_record(record_status,rep_no) values('δ����',(select rep_no from emms_rep where eqt_no =?))");
					st.setInt(1, eqtno);
					i = i+st.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					DBUtil.closeResource(st, con);
				}
		if(i == 2) result=true;
		return result;
	}
//��������
	
	public boolean DeleteRep(int eqtno){
		int i = 0;
		boolean result=false;
		//�������ݿ⣬��rep״̬��Ϊ������ͬʱ����reorde����
		Connection con = DBUtil.getConnection();
		PreparedStatement st = null;
		try {
			st=con.prepareStatement("update commitrep set rep_status='����' where eqt_no =?;");
			st.setInt(1, eqtno);
		
			i=i+st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeResource(st, con);
		}
		if (i == 0) return result;
//��record���в������ݣ�
		//����ά�޼�¼��Ϣ
				con=DBUtil.getConnection();
				try {
					st=con.prepareStatement(" update emms_record a inner join emms_rep b on b.rep_no=a.rep_no and eqt_no= ? set a.record_status='����';");
					st.setInt(1, eqtno);
					i = i+st.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					DBUtil.closeResource(st, con);
				}

		if(i >= 2) result=true;
		return result;
	}
}
