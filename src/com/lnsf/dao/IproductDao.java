package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Product;

public interface IproductDao {
	
	//查找记录是否存在
	public boolean selectProductById(int productId);
	
	// 查找所有记录，返回结果集至List
	public List<Product> all();

	// 增加，返回布尔值
	public boolean insert(Product p);

	// 根据商品ID“删除”，返回布尔值
	public boolean delete(int productId);

	// 修改，返回布尔值
	public boolean update(Product p);
}
