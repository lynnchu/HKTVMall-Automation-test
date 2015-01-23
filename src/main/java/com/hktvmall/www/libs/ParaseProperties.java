package com.hktvmall.www.libs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ParaseProperties {
	 Properties props = new Properties();
	 String value;
	 String value_recode;
	 
	public ParaseProperties(String filePath){
		this.loadProperties(filePath);
	}
	
	public void loadProperties(String FilePath){
		  try{ 
			 //InputStream in = new BufferedInputStream(new FileInputStream(filePath+testdata));
			  InputStream in = new FileInputStream(FilePath);
			 InputStreamReader rin = new InputStreamReader(in);
			 BufferedReader inr = new BufferedReader(rin);
			 props.load(inr);
		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
	}
	
	public String getKey(String keyname){
		 value = props.getProperty(keyname).trim();
		  try{
		  //String value2 = new String(value_utf8,"UTF-8");
		   value_recode = new String(value.getBytes("UTF-8"),"UTF8");
		  }
		  catch(UnsupportedEncodingException e){
			  e.printStackTrace();
		  } 
		  return value_recode;
	}

}
