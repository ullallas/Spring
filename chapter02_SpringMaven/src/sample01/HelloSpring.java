package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MessageBean messageBean = (MessageBean) context.getBean("messageBeanImpl");
		messageBean.sayHello();
		messageBean.sayHello("딸기", 20000);
		messageBean.sayHello("참외", 5000, 3);

	}

}
