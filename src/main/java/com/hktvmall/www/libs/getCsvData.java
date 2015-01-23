package com.hktvmall.www.libs;

import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;


public class getCsvData {
	
	public String FilePath;
	public ArrayList<String[]> list; 
	public CSVReader reader;
	public String Value;
	public String[] nextLine;
	
	public getCsvData(String filepath){
		this.FilePath = filepath;
	}
	
	public String getTestData(String columnName,String lineName){
		list = new ArrayList<String[]>();
		  try{  
			  reader= new CSVReader(new FileReader(FilePath));
			  while((nextLine = reader.readNext())!= null){
				  list.add(nextLine);
			  }
			  reader.close();
			  int count = 0;
			  int index = 0;
			  
			  for (String j : list.get(0)) {
					if(j.equals(columnName)){
						index =  count;
					}
					count++;
				} 
			  
			  for(String[] i:list){
				  if(i[0].equals(lineName)){
					  Value = i[index].toString();
				  }
			  }
			  }
			  catch(Exception ex){
				  ex.printStackTrace();
			  }

	
		  return Value;  
	}
	
}


