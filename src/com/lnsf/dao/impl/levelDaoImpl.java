package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.IlevelDao;
import com.lnsf.model.Level;
import com.lnsf.utils.DataAccess;

public class levelDaoImpl implements IlevelDao {
	// 查找所有记录，返回结果集至List
	@Override
	public List<Level> all() {
		String sql = "select * from level";
		List<Level> l = new ArrayList<Level>();
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			rs = prepstat.executeQuery();
			while (rs.next()) {
				Level L = new Level(rs.getInt("level_id"),
						rs.getString("level_name"), rs.getInt("low_point"),
						rs.getInt("high_point"), rs.getInt("flag"));
				l.add(L);
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
	public boolean insert(Level level) {
		String sql = "insert into Level(level_name,low_point,high_point) values(?,?,?)";
		String level_name = level.getLevel_name();
		int low_point = level.getLow_point();
		int high_point = level.getHigh_point();
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setString(1, level_name);
			prepstat.setInt(2, low_point);
			prepstat.setInt(3, high_point);
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
	public boolean delete(int lid) {
		String sql = "update level set flag=0 where level_id = ?";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setInt(1, lid);
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
	public boolean update(Level level) {
		String sql = "update level set level_name = ?, low_point = ?,high_point = ? where level_id = ?";
		String level_name = level.getLevel_name();
		int low_point = level.getLow_point();
		int high_point = level.getHigh_point();
		int level_id = level.getLevel_id();
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setString(1, level_name);
			prepstat.setInt(2, low_point);
			prepstat.setInt(3, high_point);
			prepstat.setInt(4, level_id);
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
	public Level selectlevelbyid(int lid) {
		String sql = "select * from level where level_id = ? and flag = 1";
		Level l = new Level();
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setInt(1, lid);
			rs = prepstat.executeQuery();
			if (rs.next()) {
				l.setLevel_id(lid);
				l.setLevel_name(rs.getString("level_name"));
				l.setLow_point(rs.getInt("low_point"));
				l.setHigh_point(rs.getInt("high_point"));
				l.setFlag(rs.getInt("flag"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);
		}
		return l;
	}
}
