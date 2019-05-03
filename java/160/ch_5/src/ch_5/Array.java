package ch_5;

import java.util.ArrayList;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arrayobj = new String[2];
		arrayobj[0] = "one";
		arrayobj[1] = "two";
		//arrayobj[2] = "three"; 배열은 선언순간 확장 x
		for(int i=0; i<arrayobj.length; i++) {
			System.out.println(arrayobj[i]);
		}
		
		ArrayList<String> exam = new ArrayList<String>();
		exam.add("one");
		exam.add("two");
		exam.add("three");
		for(int i=0; i<exam.size(); i++) {
			String value = exam.get(i);
			System.out.println(value);
		}
		
	}

}
