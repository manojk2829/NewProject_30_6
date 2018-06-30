package string_Pack;

import org.testng.annotations.Test;

public class String_Class_Study {
	
	@Test
	public void string_Method() {
		String str = "Today is saturday, Office is close today";
		String str1 = "today is saturday, Office is close today";
		
		String[] split_space= str.split("Office");
		/*for(int i=0;i<split_space.length;i++) {
			//System.out.println(str.charAt(i));
			System.out.print(split_space[i]);
		}
		System.out.println("------------------------------");
		System.out.println(str.length());
		System.out.println(str.equals(str1));*/
		System.out.println("s ----- > "+ str.indexOf('t'));
		System.out.println("s ----- > "+ str.indexOf('s', 10));
		System.out.println("Index of Office ----- > "+ str.indexOf("is"));
		System.out.println("SubString -- > " + str1.substring(7, 10));
		
		String i="100";
		int x=Integer.parseInt(i);
		System.out.println(x);
		
		int n=200;
		String xx=String.valueOf(n);
		System.out.println(xx);
	}

}
