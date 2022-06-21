package sample02;

import lombok.Setter;

public class CalcMul implements Calc {
	@Setter
	private int x, y;

//	public void setX(@Value("25") int x) {
//		this.x = x;
//	}
//
//	public void setY(@Value("36") int y) {
//		this.y = y;
//	}
	
	@Override
	public void calculate() {
		System.out.println(x + " * " + y + " = " + (x*y));
	}
	

}
