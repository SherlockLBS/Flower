package com.lnsf.service;

import java.util.List;

import com.lnsf.model.ProductDetail;

public interface IproductDetailService {
	// 查找所有记录，返回结果集至List
	public List<ProductDetail> all();

	// 插入
	public void insert(ProductDetail pd);

	// 循环调用insert
	public void circulation(int num, ProductDetail pd);

	// 根据商品明细ID“删除”
	public void delete(int productDetailId);

	// 更新商品明细表信息
	public void update(ProductDetail pd);
}
