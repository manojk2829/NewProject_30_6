

import java.util.Arrays;

public class AnagramStringPro {

	public static void main(String[] args) {
		IsAnagram("Manoj", "noj ma");
	   String a="manoj";
	   String b="sarita";
	   a=a+b;
	   b=a.substring(0,a.length()- b.length());
	   System.out.println("b --- > " +b);
	   a=a.substring(b.length());
	   System.out.println("a ---> " + a);
	}
	
	
	
	
	public static void IsAnagram(String s1,String s2){
		String ss1=s1.replaceAll("\\s", "");
		String ss2=s2.replaceAll("\\s", "");
		boolean status =true;
		if(ss1.length()!=ss2.length()){
			status=false;
			System.out.println("Not Anagram");
		}else{
			char[] ArraysS1=  ss1.toLowerCase().toCharArray();
			char[] ArraysS2=  ss2.toLowerCase().toCharArray();
			Arrays.sort(ArraysS1);
			Arrays.sort(ArraysS2);
            status=Arrays.equals(ArraysS1, ArraysS2);
		}
		
		if(status){
			System.out.println("Anagram");
		}else{
			System.out.println("Not");
		}
	}

}
