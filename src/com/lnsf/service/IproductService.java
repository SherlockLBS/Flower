package com.lnsf.service;

import java.util.List;

import com.lnsf.model.Product;

public interface IproductService {

	// 查找所有记录，返回结果集至List
	public List<Product> all();

	// 插入商品
	public void insert(Product p);

	// 根据商品名称查找记录
	public Product selectProductByName(String productname);

	// 根据商品ID“删除”
	public void delete(int productId);

	// 更新商品
	public void update(Product p);

}
