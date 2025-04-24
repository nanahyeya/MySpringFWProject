package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// Assertions가 가진 모든 static 메서드를 import 하겠다 !!
import static org.junit.jupiter.api.Assertions.*;

public class HelloJunitTest {
	@Test
	void helloBean() {
//		System.out.println("Hello Junit !");
		// 1. container 객체 생성
		ApplicationContext context = new GenericXmlApplicationContext("classpath:hello-di.xml");
		// 2. container 객체가 생성한 spring bean을 요청하기
		Hello helloById =  (Hello)context.getBean("hello");
		Hello helloByType = context.getBean("hello", Hello.class);
		// Spring Bean 의 주소 비교
		System.out.println(helloById == helloByType);
		assertSame(helloById, helloByType);
		
	}
}
