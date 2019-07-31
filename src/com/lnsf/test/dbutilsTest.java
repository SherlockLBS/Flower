package com.lnsf.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lnsf.model.User;
import com.lnsf.utils.DataAccess;

public class dbutilsTest {
	
    public void testSelect(){
        try {
        	//数据库连接
        	Connection conn = DataAccess.getConnection();
        	//创建QueryRunner类对象
            QueryRunner qr = new QueryRunner();
            //SQL语句
            String sql = "SELECT * FROM user";
            //查询到的结果保存在集合中
            List<User> users = qr.query(conn,sql,new BeanListHandler<User>(User.class));
            //输出查询结果
            for (User user:users){
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
    	dbutilsTest du = new dbutilsTest();
		du.testSelect();
	}

}
