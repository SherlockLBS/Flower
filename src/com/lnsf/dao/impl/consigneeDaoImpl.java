package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.IconsigneeDao;
import com.lnsf.model.Consignee;
import com.lnsf.utils.DataAccess;

public class consigneeDaoImpl implements IconsigneeDao {
	// 查找所有记录，返回结果集至List
	@Override
	public List<Consignee> all() {
		String sql = "select * from consignee";
		List<Consignee> l = new ArrayList<Consignee>();
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			rs = prepstat.executeQuery();
			while (rs.next()) {
				Consignee c = new Consignee(rs.getInt("con_id"),
						rs.getString("con_name"), rs.getString("con_tel"),
						rs.getString("con_addr"), rs.getString("user_id"),
						rs.getInt("flag"));
				l.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);
		}

		return l;
	}

	// 增加，返回布尔值
	@Override
	public boolean insert(Consignee con) {
		String sql = "insert into Consignee(user_id,con_name,con_tel,con_addr) values(?,?,?,?)";
		String user_id = con.getUser_id();
		String con_name = con.getCon_name();
		String con_tel = con.getCon_tel();
		String con_addr = con.getCon_addr();
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setString(1, user_id);
			prepstat.setString(2, con_name);
			prepstat.setString(3, con_tel);
			prepstat.setString(4, con_addr);
			prepstat.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);
		}
		return flag;
	}

	// 根据ID“删除”，返回布尔值
	@Override
	public boolean delete(int conid) {
		String sql = "update consignee set flag=0 where con_id = ? ";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setInt(1, conid);
			prepstat.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);
		}
		return flag;
	}

	// 修改，返回布尔值
	@Override
	public boolean update(Consignee con) {
		String sql = "update consignee set con_name = ?,con_tel = ?,con_addr = ? where con_id = ?";
		String con_name = con.getCon_name();
		String con_tel = con.getCon_tel();
		String con_addr = con.getCon_addr();
		int con_id = con.getCon_id();
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setString(1, con_name);
			prepstat.setString(2, con_tel);
			prepstat.setString(3, con_addr);
			prepstat.setInt(4, con_id);
			prepstat.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);
		}
		return flag;
	}

	// 根据id查找
	@Override
	public Consignee selectconsigneebyid(int conid) {
		String sql = "select * from consignee where con_id = ? and flag = 1 ";
		Consignee c = new Consignee();
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setInt(1, conid);
			rs = prepstat.executeQuery();
			if (rs.next()) {
				c.setCon_id(conid);
				c.setCon_name(rs.getString("con_name"));
				c.setCon_tel(rs.getString("con_tel"));
				c.setCon_addr(rs.getString("con_addr"));
				c.setUser_id(rs.getString("user_id"));
				c.setFlag(rs.getInt("flag"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);
		}
		return c;
	}
	
	//根据用户Id查找地址
	@Override
	public List<Consignee> selectaddrbyid(String userid) {
		List<Consignee> l=new ArrayList<Consignee>();
		String sql="select * from consignee where user_id= ?";
		Connection conn=null;
		PreparedStatement prepstat=null;
		ResultSet rs=null;
		try{
			conn=DataAccess.getConnection();
			prepstat=conn.prepareStatement(sql);
			prepstat.setString(1, userid);
			rs=prepstat.executeQuery();
			while(rs.next()){
				Consignee c=new Consignee(
					rs.getInt("con_id"),rs.getString("con_name"),rs.getString("con_tel"),
					rs.getString("con_addr"),rs.getString("user_id"),rs.getInt("flag"));
				l.add(c);
			}		
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DataAccess.closeConnection(rs, prepstat, conn);
		}
		return l;
	}

}
