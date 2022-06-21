package sample01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageBeanImpl implements MessageBean {
	private String fruit;
	private int cost, qty;
	
	public MessageBeanImpl(@Value("수박") String fruit) {
		this.fruit = fruit;
	}
	
	@Autowired
	public void setCost(@Value("12000") int cost) {
		this.cost = cost;
	}

	@Autowired
	public void setQty(@Value("1") int qty) {
		this.qty = qty;
	}


	@Override
	public void sayHello() {
		System.out.println(fruit + "\t" + cost + "\t" + qty);
		
	}

	@Override
	public void sayHello(String fruit, int cost) {
		System.out.println(fruit + "\t" + cost + "\t" + qty);
		
	}

	@Override
	public void sayHello(String fruit, int cost, int qty) {
		System.out.println(fruit + "\t" + cost + "\t" + qty);
		
	}

}
