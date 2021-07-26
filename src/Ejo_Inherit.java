class Transportation{
	String engine = "Engine";
	void move() {
		System.out.println("움직인다");
	}
}

class Changeable{
	int seat;
	int wheel;
	int rate;
	
	Changeable(){
		this(30, 4, 1250);  //시내버스 기준
	}
	
	Changeable(int seat, int wheel, int rate){
		this.seat = seat;
		this.wheel = wheel;
		this.rate = rate;
	}
}

class Bus extends Transportation {
	Changeable change;
	int busStop;  //해당 버스가 멈추는 정류장 개수
	
	Bus(){
		this(10, new Changeable());
	}
	
	Bus(int busStop, Changeable change){
		this.busStop = busStop;
		this.change = change;
	}
	
	void nowStop() {
		System.out.println("이번 정류장은 비트캠프.. 비트캠프 입니다");
	}

	@Override
	void move() {
		
	System.out.println("달린다");
	}
	
}


class ExpressBus extends Bus{
	int window;
	
	ExpressBus(){
		this(12, 8, new Changeable(20, 4, 20000));
	}
	
	ExpressBus(int window, int busStop, Changeable change){
		this.window = window;
		this.busStop = busStop;  //Bus클래스에서 상속
		this.change = change;
	}
	
	void quality() {
		System.out.println("좌석이 별이 다슷개!!!");
	}
}


class Flight extends Transportation {
	Changeable change;
	int toilet;
	
	Flight(){
		this(2, new Changeable(150, 22, 100000));
	}
	
	Flight(int toilet, Changeable change){
			this.toilet = toilet;
			this.change = change;
	}
	
	void fly() {
		System.out.println("이륙합니다. 착륙합니다.");
	}
}


class Subway extends Transportation {
	Changeable change;
	int room;
	
	Subway(){
		this(5, new Changeable(100, 100, 1250));
	}
	
	Subway(int room, Changeable change){
		this.room = room;
		this.change = change;
	}
	
	void nowStation() {
		System.out.println("이번 역은 강남역 입니다^^");
	}
}


public class Ejo_Inherit {
	public static void main(String []args) {
		Bus b = new Bus();
		b.move();
	}
}
