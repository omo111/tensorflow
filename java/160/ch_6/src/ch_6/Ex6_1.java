package ch_6;

public class Ex6_1 {

	public static void main(String[] args) {
		
		//String�� �ּҿ��ִ� ������ ���� �޶����� ���ο� ��ü������µ� ������ ���� �ؿ��� �ϳ��� ���� ����� ��ɾ��̴� ����
		String str = "����";
		int i = 1;
			for (i= 0; i< 50; i++) {
				str = str + i ;
			}
		System.out.println(str);
		
		
		// Stringbuffer ��ü���� �Ѵ�.
		StringBuffer sd =new StringBuffer();
		//����� sd �� ���� �־��ش�. ��ü��.append();
		sd.append("����");
		
		for( i=0; i< 50 ; i++) {
			sd.append(i);
		}
		//Strungbuffer �θ��� ��ü ����� ��ü��.toString() ���� ���־���Ѵ�.(String���κ���)
		System.out.println(sd.toString());

	}
}
