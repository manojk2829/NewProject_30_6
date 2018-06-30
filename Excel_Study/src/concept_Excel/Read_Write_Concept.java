package concept_Excel;

import org.testng.annotations.BeforeTest;
import excel_Reader_File.Xls_Reader;

public class Read_Write_Concept {
	
	@BeforeTest
	public void read_write_test() {
		String sheetName="sheet1";
		String url="https//google.com/";
		String last= "&view-list/Done/";
		String colName="Result";
		Xls_Reader xls=new Xls_Reader("D://report//Data_Test.xlsx");
		int rowC=xls.getRowCount(sheetName);
		int colC=xls.getColumnCount(sheetName);
		System.out.println(colC);
		System.out.println(rowC);
		for(int r=2;r<=rowC;r++){
			String fullurl=url+xls.getCellData(sheetName, 0, r)+xls.getCellData(sheetName, 3, r)+last+xls.getCellData(sheetName, 1, r);
			xls.setCellData(sheetName, colName, r, "");
			xls.setCellData(sheetName, colName, r, fullurl);
			
			/*for(int c=0;c<colC;c++) {
				//System.out.print(xls.getCellData(sheetName, c, r)+" ");
				
			}
			System.out.println("Done");
			System.out.println();*/
		}
	}

}
