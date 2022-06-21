package sample05;

import java.util.Scanner;

public class SungJukImpl implements SungJuk {
	private String name;
	private int kor, eng, math;
	private int tot;
	private double avg;
	
	public SungJukImpl() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		name = scan.next();
		System.out.print("국어 입력 : ");
		kor = scan.nextInt();
		System.out.print("영어 입력 : ");
		eng = scan.nextInt();
		System.out.print("수학 입력 : ");
		math = scan.nextInt();
	}

	@Override
	public void calc() {
		tot = kor+eng+math;
		avg = (double)tot / 3;
		//avg = tot / 3.0;

	}

	@Override
	public void display() {
		calc();
		
		System.out.println("이름" + "\t" + "국어" + "\t" + "영어" + "\t" + "수학" + "\t" + "총점" + "\t" + "평균");
		System.out.println(name  + "\t" + kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + String.format("%.3f", avg));
		//System.out.println(this);
	}
	
//	public String toString() {
//		return name  + "\t" + kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + String.format("%.3f", avg);
//	}

}
