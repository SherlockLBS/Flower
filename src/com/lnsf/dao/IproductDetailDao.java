package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.ProductDetail;

public interface IproductDetailDao {
	
	//查询一条记录是否存在
	public boolean selectProductDetailById(int productDetailId);
	
	// 查找所有记录，返回结果集至List
	public List<ProductDetail> all();

	// 增加，返回布尔值
	public boolean insert(ProductDetail pd);

	// 根据商品明细ID“删除”，返回布尔值
	public boolean delete(int productDetailId);

	// 修改，返回布尔值
	public boolean update(ProductDetail pd);
}
