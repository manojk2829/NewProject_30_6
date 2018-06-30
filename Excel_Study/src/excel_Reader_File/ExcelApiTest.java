package excel_Reader_File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelApiTest {
	   public FileInputStream fis;
       public FileOutputStream fos = null;
       public XSSFWorkbook workbook = null;
       public XSSFSheet sheet = null;
       public XSSFRow row = null;
       public XSSFCell cell = null;
       String xlFilePath;	
	
    @Test
	public void Read_Write_Test() throws Exception {
		String str1="Manoj Kushwaha -- ";
		String str_last=" -- R Systems.";
		String sheetName="sheet1";
		String sheetName_Result="sheet2";
		Xls_Reader xls=new Xls_Reader("D://report//TestData_Test.xlsx");
		int rowCount= xls.getRowCount(sheetName);
		int col_Count=xls.getColumnCount(sheetName);
		System.out.println(rowCount);
		for(int r=1;r<=rowCount;r++) {     
			String fullData=str1+xls.getCellData(sheetName, 3, r)+str_last+xls.getCellData(sheetName, 1, r);
			for(int c=0;c<=col_Count;c++) {	
				//System.out.print(xls.getCellData(sheetName, c, r)+" ");
				write_Data_in_Excel(sheetName_Result, r, c, "");
				write_Data_in_Excel(sheetName_Result, r, 0, fullData);
				System.out.print(xls.getCellData(sheetName, c, r)+" " + fullData);
			}
			System.out.println();
			
			/*write_Data_in_Excel(sheetName_Result, r, 1, "");
			write_Data_in_Excel(sheetName_Result, 2, 4, fullData);
			write_Data_in_Excel(sheetName_Result, 3, 4, fullData);
			write_Data_in_Excel(sheetName_Result, 4, 4, fullData);
			//write_Data_in_Excel(sheetName_Result, r,1, fullData);
			System.out.println(fullData);
			*/
		}
		System.out.println();
	}
	
	public void write_Data_in_Excel(String sheetName, int row,int colNum, String CellData) {
    	File src=new File("D://report//TestData_Test.xlsx");    	
    	try{
    	FileInputStream fis=new FileInputStream(src);
    	XSSFWorkbook wb = new XSSFWorkbook(fis);    	
    	XSSFSheet sh=wb.getSheet(sheetName);
    	XSSFRow rowCreate = sh.createRow(row);
        XSSFCell cell = rowCreate.createCell(colNum);
        cell.setCellValue(CellData);
    		//sh.getRow(row).createCell(colNum).setCellValue();  
        
        FileOutputStream fos=new FileOutputStream(src);
        wb.write(fos);
        fos.flush();
    		    	
    }
    	catch(Exception ex) {
    		System.out.println(ex.getMessage());
    	}
    }
    
}
