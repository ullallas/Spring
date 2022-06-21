package sample04;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String phone;
	private Outputter Outputter;

	public MessageBeanImpl(String name) {
		System.out.println("MessageBeanImpl(String name)");
		this.name = name;
	}

	public void setPhone(String phone) {
		System.out.println("setPhone(String phone)");
		this.phone = phone;
	}
	
	public void setOutputter(Outputter outputter) {
		System.out.println("setOutputter(Outputter outputter)");
		Outputter = outputter;
	}

	@Override
	public void helloCall() {
		Outputter.output("이름 = " + name + "\t핸드폰 = " + phone);

	}

}
