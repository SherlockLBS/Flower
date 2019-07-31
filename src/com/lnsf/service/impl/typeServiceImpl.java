package com.lnsf.service.impl;

import java.util.List;

import com.lnsf.model.Type;
import com.lnsf.service.ItypeService;

public class typeServiceImpl implements ItypeService{
	
	public ItypeService ItypeService;
	
	public List<Type> all(){
		return ItypeService.all();
	}

}
