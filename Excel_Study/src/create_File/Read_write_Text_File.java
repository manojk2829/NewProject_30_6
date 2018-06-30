package create_File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Read_write_Text_File {

	public static void main(String[] args) throws IOException {
		Date d=new Date();
		String FN=d.toString().replaceAll(" ", "_").replace(":", "_")+".txt";
		File src= new File("D://MANOJ//"+FN);
		
	    FileWriter fw = new FileWriter(src);
	    BufferedWriter bw=new BufferedWriter(fw);
	    bw.write("11111111111111111111111");
	    bw.newLine();
	    bw.write("1");
	    bw.write("232");
	    bw.newLine();
	    bw.flush();
	    
	    FileReader fr=new FileReader(src);
	    BufferedReader br=new BufferedReader(fr);
	    
	    System.out.println(br.readLine());
	    String x="";
	    while((x=br.readLine())!=null) {
	    	System.out.println(x);
	    }
	    
	    
	    
	}

}
