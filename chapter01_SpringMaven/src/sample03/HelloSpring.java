package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		//ApplicationContext context = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//스프링 설정 파일에 가서 Bean을 얻어와라
		MessageBean messageBean = (MessageBean)context.getBean("messageBean"); //자식 = (자식)부모
		messageBean.sayHello("Spring");
		System.out.println("-----------------");
		
		MessageBean messageBean2 = context.getBean("messageBean", MessageBean.class); //자식 = (자식)부모
		messageBean2.sayHello("Spring");
		System.out.println("-----------------");
		
		MessageBean messageBean3 = (MessageBean)context.getBean("messageBean"); //자식 = (자식)부모
		messageBean3.sayHello("Spring");
		System.out.println("-----------------");
		
				
	}

}
