/*
 변수 <-> 상수
 상수 : 초기화가 되고나서 (최초값 할당)이 되면 변경 불가
 상수자원 : 고유값(주민번호) , 수학 (PI=3.141592 , 소프트웨어 버전 번호 , 시스템번호 )
 상수 관용적으로 대문자
 
 java : final int NUM = 0;
 c#   : const integer NUM=0;
 
 final 키워드
 
 final class Math {} >> 상속금지 >> 설계도 (상속 안되 1장) >> final class MyMap
 final void print() {} >> 상속관계에서 재정의 금지 (override)
 
 public static final jumin; //객체간 공유자원 (변하지 않는)***************************
 --public static final void print() {} 별의미가 없다
 
 
 */

class Vcard {
	final String KIND = "herat";	//상수는 반드시 초기화를 해야 사용 가능하다
	final int NUM = 10;
	void method() {
		System.out.println(Math.PI);
	}
}

class Vcard3 {

}
class Vcard2 {
	final String KIND;
	final int NUM;
	
	//상수에게 믿음 ... 너 객체 만들어지면 반드시 초기화 된다
	
	Vcard2() {
		this("heart", 10);
	}
	
	Vcard2(String kind, int num) {
		this.KIND = kind;
		this.NUM = num;
		
	}

	@Override
	public String toString() {
		return "Vcard2 [KIND=" + KIND + ", NUM=" + NUM + "]";
	}
	
}


public class Ex07_FInal {

	public static void main(String[] args) {
		Vcard vcard = new Vcard();
		System.out.println(vcard.KIND);
		vcard.method();
		
		
		Vcard2 card2 = new Vcard2("spade",7);
		System.out.println(card2.toString());
		
	}

}
