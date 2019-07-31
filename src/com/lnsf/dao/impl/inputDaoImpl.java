package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.IinputDao;
import com.lnsf.model.Input;
import com.lnsf.utils.DataAccess;

public class inputDaoImpl implements IinputDao {
	// 查找所有记录，返回结果集至List
	@Override
	public List<Input> all() {
		List<Input> l = new ArrayList<Input>();
		String sql = "select * from input";
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			rs = prepstat.executeQuery();
			while (rs.next()) {
				Input i = new Input(rs.getInt("input_id"),
						rs.getInt("flower_id"), rs.getInt("input_num"),
						rs.getFloat("intput_price"),
						rs.getString("input_date"), rs.getInt("flag"));

				l.add(i);
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
	public boolean insert(Input input) {
		String sql = "insert into input(flower_id,input_num,intput_price,input_date) values (?,?,?,?)";
		int flower_id = input.getFlower_id();
		int input_num = input.getInput_num();
		float input_price = input.getInput_price();
		String input_date = input.getInput_date();
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setInt(1, flower_id);
			prepstat.setInt(2, input_num);
			prepstat.setFloat(3, input_price);
			prepstat.setString(4, input_date);
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
	public boolean delete(int inid) {
		String sql = "update input set flag=0 where input_id = ?";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setInt(1, inid);
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
	public boolean update(Input input) {
		String sql = "update input set input_num = ?,input_price = ?,input_date = ? where input_id = ?";
		int input_num = input.getInput_id();
		float input_price = input.getInput_price();
		String input_date = input.getInput_date();
		int input_id = input.getInput_id();
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setInt(1, input_num);
			prepstat.setFloat(2, input_price);
			prepstat.setString(3, input_date);
			prepstat.setInt(4, input_id);
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);
		}

		return flag;
	}

	// 按Id查找记录
	@Override
	public Input selectinputbyid(int inid) {
		String sql = "select * from input where input_id = ? and flag = 1";
		Input i = new Input();
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setInt(1, inid);
			rs = prepstat.executeQuery();
			if (rs.next()) {
				i.setInput_id(inid);
				i.setFlower_id(rs.getInt("flower_id"));
				i.setInput_num(rs.getInt("input_num"));
				i.setInput_price(rs.getFloat("intput_price"));
				i.setInput_date(rs.getString("input_date"));
				i.setFlag(rs.getInt("flag"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);
		}
		return i;
	}

}
