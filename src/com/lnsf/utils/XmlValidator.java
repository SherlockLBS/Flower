package com.lnsf.utils;

import java.io.File;
import java.io.IOException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XmlValidator {
	public static boolean validate(String xmlPath, String xsdPath){
		boolean flag = false;
		String base = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		xmlPath = base + xmlPath;
		xsdPath = base + xsdPath;
		try {
		//1.创建模式工厂SchemaFactory
		SchemaFactory sf = SchemaFactory.newInstance
				("http://www.w3.org/2001/XMLSchema");
		//2.通过XSD文件创建Schema
		File f = new File(xsdPath);
		Schema s = sf.newSchema(f);
		//3.由模式创建验证器Validator
		Validator v = s.newValidator();
		//4.使用验证器验证XML文件
		Source source = new StreamSource(xmlPath);
		v.validate(source);
		flag = true;
		} catch (SAXException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
