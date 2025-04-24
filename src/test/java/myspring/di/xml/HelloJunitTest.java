package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloJunitTest {

	@Test
	void helloBean() {
//		System.out.println("Hello Junit !");
		ApplicationContext context = new GenericXmlApplicationContext("");
		
		
	}
	
}
