package sample02;

public class HelloSpring {

	public static void main(String[] args) {
		MessageBeanKo messageBeanKo = new MessageBeanKo(); //1:1관계, 결합도 100%
		
		//부모 = 자식, 다형성
		MessageBean messageBean = new MessageBeanKo();
		messageBean.sayHello("Spring");
		
		messageBean = new MessageBeanEn();
		messageBean.sayHello("Spring");
	}

}
