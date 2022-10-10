package testSauceDemo;

import org.testng.annotations.*;
import utililty.ExcelUtil;
import utililty.ReadProperties;

public class demo extends ExcelUtil{

@Test(dataProvider = "excelData")
public void search(String key1) throws Exception {
	String path = ReadProperties.getData("excelpath");
	String sheetname="sheet1";
	int rowval=1;
	int z;
 for(z=0;z<=10;z++) { 
	String usrname = ExcelUtil.getExcelData(path,sheetname,rowval,z);
	System.out.println(usrname);
 }
   
}
  
 
  	
  
}
