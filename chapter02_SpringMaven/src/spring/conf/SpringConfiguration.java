package spring.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample01.MessageBeanImpl;
import sample02.CalcAdd;
import sample02.CalcMul;
import sample05.SungJukDTO2;

@Configuration
public class SpringConfiguration {
	
//	@Bean
	//빈으로 생성하는 메소드
	//메소드명은 반드시 id명과 똑같이 만들어야 한다.
//	public MessageBeanImpl messageBeanImpl() {
//		return new MessageBeanImpl("수박");
//	}
	
	@Bean(name="messageBeanImpl")
	public MessageBeanImpl getMessageBeanImpl() {
		return new MessageBeanImpl("수박");
	}
	
	@Bean
	public CalcAdd calcAdd() {
		return new CalcAdd(22, 77);
	}
	
	@Bean(name="calcMul")
	public CalcMul getCalcMul() {
		return new CalcMul();
	}
	
//	@Bean
//	public List<SungJukDTO2> arrayList() {
//		return new ArrayList<SungJukDTO2>();
//	}
	
}
