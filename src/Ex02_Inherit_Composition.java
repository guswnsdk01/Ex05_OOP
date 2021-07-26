/*
 실무 계발 환경(현업)
 설계도 1장은 연습하는 것 말고는 없다
 
 설계도 많다 (업무가 복잡하다) >> 하나의 설계도 불가 >> 규칙에 맞게 여러개의 설계도 
 쇼핑몰 >> 회원관리 , 배송 , 주문관리 , 상품관리 , 관리자 ....(도메인(업무)) >> 각각의 설계도
 
 배송 >> 회원 , 상품 
 
 고민 : 여러개의 설계도를 어떤 기준에서 나누고 합치고 작업

 학자 정의 ... 업무 지식이 없더라도 업무 ... 잣대 ...
 1. is ~ a  > ~은 ~이다(부모를 뒤에) > 상속
 2. has ~ a > ~은 ~가지고 있다 > 포함
 
 예)
 원   도형
 원은 도형이다(0)
 원은 도형을 가지고 있다(x)
 >> 원 extends 도형
 
 
 원		점  관계
 원은 점이다 (x)	
 원은 점을 가지고 있다(0) 
 >> class 원 { 점(부품) }
 
 개인적인 ...
 학술적(70) + 30 경험
 
 경찰 	권총
 경찰은 권총이다 (x)
 경찰은 권총을 가지고 있다(0)
 class 권총 {}
 class 경찰 {
 	//권총 ... 항상가지는 것이 아니다
 	 
 	 void 출동(권총) {
 	 
 	 }
} 

예) 원 , 삼각형 , 사각형 만드는 설계도를 작성하세요

원은 도형이다
삼각형은 도형이다
사각형은 도형이다

도형 : 추상화 , 일반화 >> 공통자원(분모) >> 그리다 , 색상
원 : 구체화 , 특수화 >> 원만이 가지는 특징 >> 반지름 , 한점(좌표)

점 : 좌표값(x,y)
원은 점을 가지고 있다
삼각형은 점을 가지고 있다
사각형은 점을 가지고 있다

class Shape {색상 , 그리다}
class Point {x, y}

원은

원 extends shape {
	Point(부품) 
}



 */
class Shape {
	String color = "gold";
	void draw() {
		System.out.println("그리다");
	}
	
}

class Point{
	int x;
	int y;
	
	//x, y 기본값이 있고
	Point() {
		//this.x = 1;
		//this.y = 1;
		this(1, 1);
	}
	
	//필요에 따라서는 입력 받고 싶다
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
}

//원을 .... (원의 정의는 한점과 반지름을 가지고 있다)
//1. 원은 도형이다
//2. 원은 점을 가지고 있다 (member field : 부품 타입)
//3. 원은 반지름을 가지고 있다(특수성) r

class Circle extends Shape {
	Point point; //포함 (부품 타입)
	int r; //원의 구체화 , 특수성
	
	Circle() {
//		this.r = 10;
//		this.point = new Point(10,20);
		this(10,new Point(10,20));
	}
	
	Circle(int r , Point point) {
		this.r = r;
		this.point = point;
	}
	
	
}
//원 만든 것을 참조해서
//삼각형을 만드세요
//삼각형은 3개의 점과 그리다 라는 기능을 가지고 있다
//Shape , Point		제공 받아서 사용
//default 로 삼각형을 만들수 있고 3개의 점을 받아서 삼각형을 그릴 수 있다
// (x,y) (x,y) (x,y)

/*
 60점
class Triangle extends Shape {
	Point x;	//부품타입 .. 참조
	Point y;
	Point z;
	
	public Triangle() {
		this.x = new Point(10, 20);
		this.y = new Point(30, 40);
		this.z = new Point(50, 60);
	}
	
	Triangle(Point x, Point y, Point z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
}
*/

//80점 (반복코드 제거)
/*class Triangle extends Shape {
	Point x;	//부품타입 .. 참조
	Point y;
	Point z;
	
	public Triangle() {
//		this.x = new Point(10, 20);
//		this.y = new Point(30, 40);
//		this.z = new Point(50, 60);
		this(new Point(10,20) , new Point(30,40), new Point(50,60));
	}
	
	Triangle(Point x, Point y, Point z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	//추가기능 구현 가능 (삼각형만이 가지는 것)
	void trianglePoint() {
		System.out.printf("x : (%d,%d)\t", x.x,x.y);
		System.out.printf("x : (%d,%d)\t", y.x,y.y);
		System.out.printf("x : (%d,%d)\t", z.x,z.y);
		System.out.println();
	}
}
*/

class Triangle extends Shape {
	Point[] pointarray;
	
	Triangle() {
//		this.pointarray = new Point[3];
//		pointarray[0] = new Point(10,20);
//		pointarray[1] = new Point(30,40);
//		pointarray[2] = new Point(50,60);
		
		this(new Point[] {new Point(10,20), new Point(30,40), new Point(50,60)});
		
	}
	

	
	Triangle(Point[] pointarray) {
		this.pointarray = pointarray;
	}
	
	//추가기능 구현 가능 (삼각형만이 가지는 것)
	void trianglePoint() {
		for(Point point : this.pointarray) {
			System.out.printf("point : (%d,%d)\t\n" , point.x , point.y);
		}
	}
}

public class Ex02_Inherit_Composition {

	public static void main(String[] args) {
		Circle circle = new Circle();
		System.out.println(circle.r);
		System.out.println(circle.point.x);
		System.out.println(circle.point.y);
		circle.draw();
		System.out.println(circle.color);
		System.out.println("-------------------------------");
		
		Circle circle2 = new Circle(50, new Point(1,5));
		System.out.println("반지름 : " + circle2.r);
		System.out.println("x 좌표 : " + circle2.point.x);
		System.out.println("y 좌표 : " + circle2.point.y);
		circle.draw();
		System.out.println("색상 : " + circle2.color);
		
		System.out.println("-------------------------------");
		Triangle triangle = new Triangle();
		triangle.trianglePoint();
		triangle.draw();

		System.out.println("-------------------------------");
		
		Point[] pointarr = {new Point(1,2), new Point(3,4), new Point(5,6)};
		Triangle triangle2 = new Triangle();
		triangle.trianglePoint();
		triangle.draw();
		
	}

}
