package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// Assertions가 가진 모든 static 메서드를 import 하겠다 !!
import static org.junit.jupiter.api.Assertions.*;


public class HelloJunitTest {
	
	ApplicationContext context;
	
	@BeforeEach
	void container() {
		// 1. container 객체 생성
		context = new GenericXmlApplicationContext("classpath:hello-di.xml");
		
		
	}
	
	@Test
	void helloBean() {
//		System.out.println("Hello Junit !");
		// 2. container 객체가 생성한 spring bean을 요청하기
		Hello helloById =  (Hello)context.getBean("hello");
		Hello helloByType = context.getBean("hello", Hello.class);
		
		// Spring Bean 의 주소 비교
		System.out.println(helloById == helloByType);
		assertSame(helloById, helloByType); //주소 비교
		//값비교
		assertEquals("Hello 스프링", helloById.sayHello());
		
		helloById.print();
		
		// Contatiner 객체가 생성한 StringPrinter 스프링빈 요청하기
		// <property name="printer" ref="strPrinter"/> 이 설정을 테스트 한 것임
		Printer printer = context.getBean("strPrinter", Printer.class);
		// toString 요청
		assertEquals("Hello 스프링", printer.toString());

		
		
	}
}
