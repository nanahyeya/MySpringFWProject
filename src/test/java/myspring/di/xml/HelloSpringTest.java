package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// SpringExtension 클래스는 ApplicationContext(컨테이너) 객체를 생성하는 역할을 함
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:hello-di.xml")
public class HelloSpringTest {
	@Autowired // Spring쪽 애들이 만든 것 
	Hello hello;
	
	@Autowired
	Printer strPrinter;
	
	@Autowired
	@Qualifier("strPrinter") // 변수명과 같은 id를 가진 bean이 없다면 이렇게 지정
	Printer printer;
	
	@Resource(name = "hello") // Java 쪽 애들이 만든 것
	Hello helloBean;
	
	
	@Test
	void helloSpringBean() {
		assertEquals("Hello 스프링", hello.sayHello());
		hello.print();
		assertEquals("Hello 스프링", strPrinter.toString());
		System.out.println(strPrinter.getClass().getName());
	
		assertEquals("Hello 스프링", printer.toString());
		assertEquals("Hello 스프링", helloBean.toString());

	}
	
}
