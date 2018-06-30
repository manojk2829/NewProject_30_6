package create_File;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Read_Properties_File {

	public static void main(String[] args) {

       Properties pro=new Properties();
       try{
    	   File src=new File(System.getProperty("user.dir")+"//src//create_File//or.properties");
    	   FileInputStream fis=new FileInputStream(src);
           pro.load(fis);
       }catch(Exception ex) {
    	   System.out.println(ex.getMessage());
       }
       
       System.out.println(pro.getProperty("name"));
       System.out.println(pro.getProperty("age","More then 36"));
	}

}
