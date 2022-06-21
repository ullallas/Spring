package sample05;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Scope("prototype")
@Data
public class SungJukDTO2 {
	private String name;
	private int kor, eng, math, tot;
	private double avg;
	
	public String toString() {
		return name  + "\t" + kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + String.format("%.3f", avg);
	}
}
