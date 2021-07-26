/*
 this : 객체 자신을 가리키는 this (this.empno , this.ename)
 this : 생성자를 호출하는 this ( this(100,"red"))
 
 
 상속
 
 부모(base)
 
 자식 (this)
 
 super(상속관계에서 부모객체의 주소) : 상속관계에서 부모자원에 접근

 1. super >> 상속관계에서 자식이 부모의 접근 주소
 2. super >> 상속관계에서 부모의 생성자를 호출(명시적으로)
 
 Tip)
 C# : base()
 Java : super()
 
 
 */

class Base {
	String basename;
	Base() {
		System.out.println("Base 기본 생성자 함수");
	}
	Base(String basename) {
		this.basename = basename;
		System.out.println("basename : " + this.basename);
	}
	
	void method() {
		System.out.println("나는 부모 함수");
}
}

class Derived extends Base {
	String dname;
	Derived() {
		System.out.println("Derived 기본 생성자 함수");
	}
	
	Derived(String dname) {
		super(dname); //부모 생성자를 호출 (상속관계)
		this.dname = dname;
		System.out.println("dname : " + this.dname);
	}
	@Override
	void method() {
		System.out.println("부모 함수 재정의 ....");
	}

	//그런데 어느날 .... 부모님이 생각 .... 그리워요
	//재정의 되었다면 부모자원에 접근 불가 ....
	
	//접근 방법 (super)	: 별도의 함수 안에서
	void parent_method() {
		
		super.method(); //부모자원을 호출
		
	}
}

public class Ex06_Inherit_super {

	public static void main(String[] args) {
//		Derived d = new Derived();

		Derived d2 = new Derived("홍길동");
		d2.method();
		
		d2.parent_method();
	}

}
