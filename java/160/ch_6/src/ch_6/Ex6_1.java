package ch_6;

public class Ex6_1 {

	public static void main(String[] args) {
		
		//String은 주소에있는 데이터 값이 달라지면 새로운 객체를만드는데 위에는 낭비 밑에는 하나로 묶어 사용한 명령어이다 차이
		String str = "시작";
		int i = 1;
			for (i= 0; i< 50; i++) {
				str = str + i ;
			}
		System.out.println(str);
		
		
		// Stringbuffer 객체생성 한다.
		StringBuffer sd =new StringBuffer();
		//사용은 sd 에 값을 넣어준다. 객체명.append();
		sd.append("시작");
		
		for( i=0; i< 50 ; i++) {
			sd.append(i);
		}
		//Strungbuffer 로만든 객체 출력은 객체명.toString() 으로 해주어야한다.(String으로변경)
		System.out.println(sd.toString());

	}
}
