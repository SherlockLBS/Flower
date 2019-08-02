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
        	//���ݿ�����
//        	Connection conn = DataAccess.getConnection();
        	//����QueryRunner�����
            QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
            //SQL���
            String sql = "SELECT * FROM user";
            //��ѯ���Ľ�������ڼ�����
//            List<User> users = qr.query(conn,sql,new BeanListHandler<User>(User.class));
            List<User> users = qr.query(sql,new BeanListHandler<User>(User.class));
            //�����ѯ���
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
