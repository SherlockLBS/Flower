package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.IflowerDao;

import com.lnsf.model.Flower;
import com.lnsf.utils.DataAccess;

public class flowerDaoImpl implements IflowerDao {
	// 查找所有记录，返回结果集至List
	@Override
	public List<Flower> all() {
		List<Flower> l = new ArrayList<Flower>();
		String sql = "select * from flower";
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			rs = prepstat.executeQuery();
			while (rs.next()) {
				Flower f = new Flower(rs.getInt("flower_id"),
						rs.getString("flower_name"), rs.getInt("stock"),
						rs.getInt("flower_price"), rs.getInt("flag"));
				l.add(f);
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
	public boolean insert(Flower flower) {
		String sql = "insert into flower(flower_name,stock,flower_price) values (?,?,?)";
		// int flower_id = flower.getFlower_id();
		String flower_name = flower.getFlower_name();
		int stock = flower.getStock();
		float flower_price = flower.getFlower_price();
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			// prepstat.setInt(1, flower_id);
			prepstat.setString(1, flower_name);
			prepstat.setInt(2, stock);
			prepstat.setFloat(3, flower_price);
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
	public boolean delete(int fid) {
		String sql = "update flower set flag=0 where flower_id  = ?";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setInt(1, fid);
			prepstat.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			// e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);
		}
		return flag;
	}

	// 修改，返回布尔值
	@Override
	public boolean update(Flower Flower) {
		String sql = "update flower set flower_name = ?,stock = ?,flower_price = ? where flower_id = ?";
		int flower_id = Flower.getFlower_id();
		String flower_name = Flower.getFlower_name();
		int stock = Flower.getStock();
		float flower_price = Flower.getFlower_price();
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setString(1, flower_name);
			prepstat.setInt(2, stock);
			prepstat.setFloat(3, flower_price);
			prepstat.setInt(4, flower_id);
			prepstat.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);
		}
		return flag;
	}

	// 根据id查找flower是否存在
	@Override
	public Flower selectflowerbyid(int fid) {
		String sql = "select * from flower where flower_id= ? and flag = 1";
		Flower f = new Flower();
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setInt(1, fid);
			rs = prepstat.executeQuery();
			if (rs.next()) {
				f.setFlower_id(fid);
				f.setFlower_name(rs.getString("flower_name"));
				f.setStock(rs.getInt("stock"));
				f.setFlower_price(rs.getFloat("flower_price"));
				f.setFlag(rs.getInt("flag"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);
		}

		return f;
	}
}
