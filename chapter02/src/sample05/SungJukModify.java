package sample05;

import java.util.List;
import java.util.Scanner;

import lombok.Setter;

public class SungJukModify implements SungJuk {
	@Setter
	private List<SungJukDTO2> list;
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.print("수정 할 이름 입력 : ");
		String name = scan.next();
		
		int sw = 0;
		for(SungJukDTO2 sungJukDTO2 : list) {
			if(sungJukDTO2.getName().contentEquals(name)) {
				sw=1;
				System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
				System.out.println(sungJukDTO2);
				
				System.out.println();
				System.out.print("국어 입력 : ");
				int kor = scan.nextInt();
				System.out.print("영어 입력 : ");
				int eng = scan.nextInt();
				System.out.print("수학 입력 : ");
				int math = scan.nextInt();
				
				int tot = kor+eng+math;
				double avg = tot/3.0;
				
				sungJukDTO2.setName(name);
				sungJukDTO2.setKor(kor);
				sungJukDTO2.setEng(eng);
				sungJukDTO2.setMath(math);
				sungJukDTO2.setTot(tot);
				sungJukDTO2.setAvg(avg);
				
				System.out.println();
				System.out.println(name + "님의 데이터를 수정하였습니다.");
				
				break;
			}
		} //for
		
		if(sw == 0) 
			System.out.println("찾고자 하는 이름이 없습니다");

	}

}
