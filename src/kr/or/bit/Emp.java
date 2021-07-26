package kr.or.bit;

public class Emp {	//Emp extends Object 생략
	private int empno;
	private String ename;
	
	public Emp(int empno , String ename) {
		this.empno = empno;
		this.ename = ename;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + "]";
	}
	
	
	
/*
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "사원정보" + this.empno + " , " + this.ename;
	}
*/	
	//Object toString() 그대로 사용하면 주소값을 출력하도록 ....
	//개발자가 필요에 따라서는 재정의 ... 사용한다 빈도가 높다 ....
	//자원의 정보를 확인하는 형태로 ......
	
	
}
