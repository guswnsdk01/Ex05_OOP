import kr.or.bit.Emp;

class Test2 {
	int x = 100;
	
	void print() {
		System.out.println("부모함수 Test2");
	}
}

class Test3 extends Test2 {
	int x = 300;	//C# 부모 무시하기 // 쓰지 마세요
	
	@Override
	void print() {
		System.out.println("자식이 부모 함수를 재정의 ...");
	}
	
	//overloading ... (하나의 이름으로 여러가지 기능)
	void print(String str) {
		System.out.println("나 오버로딩이야 " + str);
	}
}



public class Ex05_Inherit_Override {

	public static void main(String[] args) {
		
		Emp emp = new Emp(1000, "홍길동");
		System.out.println(emp); //kr.or.bit.Emp@3830f1c0
		System.out.println(emp.toString()); //kr.or.bit.Emp@3830f1c0
		//참조변수 emp를 출력하면 컴파일러가 뒤에 toString() 넣어서 출력
		
		Test3 t3 = new Test3();
		System.out.println(t3.x);
		
		t3.print();	//함수의 재정의를 통한 재사용
		t3.print("재정의");	//
	}

}
