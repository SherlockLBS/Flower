package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.ItypeDao;
import com.lnsf.model.Type;
import com.lnsf.utils.DataAccess;

public class typeDaoImpl implements ItypeDao {
	// 查找所有记录，返回结果集至List
	public List<Type> all() {
		List<Type> l = new ArrayList<Type>();
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			String sql = "select * from type ";
			prepstat = conn.prepareStatement(sql);
			rs = prepstat.executeQuery(sql);
			while (rs.next()) {
				Type t = new Type(rs.getInt("type_id"),
						rs.getString("type_name"), rs.getInt("flag"));
				l.add(t);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);
		}
		return l;
	}

	// // 增加，返回布尔值
	@Override
	public boolean insert(Type t) {
		String sql = "insert into type(type_name) values(?)";
		String type_name = t.getType_name();

		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setString(1, type_name);
			prepstat.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);
		}

		return flag;
	}

	// 根据类别ID“删除”，返回布尔值
	@Override
	public boolean delete(int typeid) {
		String sql = "update type set flag=0 where type_id= ?";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setInt(1, typeid);
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
	public boolean update(Type t) {
		String sql = "update type set type_name = ? where type_id = ?";
		String type_name = t.getType_name();
		int type_id = t.getType_id();
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setString(1, type_name);
			prepstat.setInt(2, type_id);
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
	public Type selecttypebyid(int typeid) {
		String sql = "select * from type where type_id = ? and flag = 1";
		Type t = new Type();
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setInt(1, typeid);
			rs = prepstat.executeQuery();
			if (rs.next()) {
				t.setType_id(typeid);
				t.setType_name(rs.getString("type_name"));
				t.setFlag(rs.getInt("flag"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);
		}

		return t;
	}
}
