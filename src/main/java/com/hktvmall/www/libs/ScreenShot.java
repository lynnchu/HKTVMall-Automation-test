package com.hktvmall.www.libs;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.xerces.dom.DeepNodeListImpl;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenShot {
	
	public static Calendar ca = Calendar.getInstance();
	public static int year = ca.get(Calendar.YEAR);
	public static int month = ca.get(Calendar.MONTH);
	public static int day = ca.get(Calendar.DATE);
	public static int minute = ca.get(Calendar.MINUTE);
	public static int hour = ca.get(Calendar.HOUR);
	public static int second = ca.get(Calendar.SECOND);
	private String filepath;
	
	
	public void takeScreenShot(String name,WebDriver driver){
		String date = year+"_"+month+"_"+day+"_"+hour+"_"+minute+"_"+second;
		File scrFie = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		filepath = System.getProperty("user.dir")+"\\ScreenShots\\";
		deleteFolder(filepath);
		try{
			Files.copy(scrFie, new File(filepath+File.separator+date+"_"+name+".jpg"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public void deleteFolder(String filePath) {
		  File delfolder=new File(filePath); 
		  File oldFile[] = delfolder.listFiles();
		  try 
		  { 
		     for (int i = 0; i < oldFile.length; i++)
		     {
		        if(oldFile[i].isDirectory())
		        {
		           deleteFolder(filePath+oldFile[i].getName()+"\\"); //Recursion delete the folder
		        }
		        oldFile[i].delete();
		     }
		  } 
		  catch (Exception e) 
		  { 
		    System.out.println("Delete the files failed"); 
		    e.printStackTrace(); 
		  }
		}

}
