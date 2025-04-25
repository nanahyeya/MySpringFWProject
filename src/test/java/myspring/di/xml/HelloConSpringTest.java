package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:hello-di.xml")

public class HelloConSpringTest {
	@Autowired
	@Qualifier("helloC")
	Hello hello;
	
	@Test
	void helloCons() {
		// System.out.println(hello.sayHello());
		assertEquals("Hello 생성자", hello.sayHello());
		hello.print();
		
		assertEquals(3, hello.getNames().size());
		assertEquals("스프링클라우드", hello.getNames().get(2));
	
		// hello.getName() ==> List<String>
		for (String name : hello.getNames()) {
			System.out.println(name);
		}
	}
}
