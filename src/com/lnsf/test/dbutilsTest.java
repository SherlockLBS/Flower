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
        	//���ݿ�����
        	Connection conn = DataAccess.getConnection();
        	//����QueryRunner�����
            QueryRunner qr = new QueryRunner();
            //SQL���
            String sql = "SELECT * FROM user";
            //��ѯ���Ľ�������ڼ�����
            List<User> users = qr.query(conn,sql,new BeanListHandler<User>(User.class));
            //�����ѯ���
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
