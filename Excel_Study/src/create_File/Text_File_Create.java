package create_File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Text_File_Create {

	public static void main(String[] args) throws IOException {
		Date d = new Date();
		String FN = d.toString().replace(" ", "_").replace(":", "_");
	    File src = new File("D://MANOJ//"+FN+"_File.xlsx");
	    boolean b = src.createNewFile();
	    System.out.println(b);
	   
	    /*FileWriter fw=new FileWriter(src);
	    BufferedWriter bw=new BufferedWriter(fw);
	    bw.write("Manavi Kushwaha");
	    bw.newLine();
	    bw.write('S');
	    bw.newLine();
	    bw.write("Sarita Kushwaha");
	    bw.flush();
	    System.out.println(bw);
	   
	    
	    
	    FileReader fr=new FileReader(src);
	    BufferedReader br=new BufferedReader(fr);
	    String x="";
	    
	    while((x=br.readLine())!=null)
	    	System.out.println(x);
	           */
	}

}
