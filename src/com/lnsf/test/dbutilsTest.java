package com.lnsf.test;

import java.awt.AWTException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lnsf.model.User;
import com.lnsf.model.UserDetail;
import com.lnsf.utils.C3p0Utils;
import com.lnsf.utils.DataAccess;

public class dbutilsTest {
	private int a = -1;
	
    public void testSelect() throws AWTException{
        try {
        	//数据库连接
//        	Connection conn = DataAccess.getConnection();
        	//创建QueryRunner类对象
            QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
            //SQL语句
            String sql = "SELECT * FROM user";
            //查询到的结果保存在集合中
//            List<User> users = qr.query(conn,sql,new BeanListHandler<User>(User.class));
            List<User> users = qr.query(sql,new BeanListHandler<User>(User.class));
            //输出查询结果
            DataAccess.clear();
            for (User user:users){
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws AWTException {
    	dbutilsTest du = new dbutilsTest();
//		du.testSelect();
//    	du.setA(0);
//    	System.out.println(du.getA());
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

}
