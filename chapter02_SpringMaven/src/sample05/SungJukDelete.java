package sample05;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SungJukDelete implements SungJuk {
	@Autowired
	@Qualifier("arrayList")
	private List<SungJukDTO2> list;
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.print("삭제 할 이름 입력 : ");
		String name = scan.next();
		
		int sw=0;
		Iterator<SungJukDTO2> it = list.iterator();
		while(it.hasNext()) {
			SungJukDTO2 sungJukDTO2 = it.next();
			if(sungJukDTO2.getName().contentEquals(name)) {
				sw=1;
				it.remove(); //임시보관소의 데이터 제거
				
				System.out.println();
				System.out.println(name + "님의 데이터를 삭제하였습니다.");
				
				break;
			}
		} //while
		
		if(sw == 0) 
			System.out.println("찾고자 하는 이름이 없습니다");
	}

}
