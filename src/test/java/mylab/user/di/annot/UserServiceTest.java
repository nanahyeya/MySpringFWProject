package mylab.user.di.annot;

timport org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.annotation.Resource;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	@Test
	void userservicetest() {
		assertNotNull(userService);
		assertNotNull(userService.getUserRepository());		
		assertEquals("MySQL", userService.getUserRepository().getDbType());
		assertNotNull(userService.getSecurityService());
		assertEquals("True", userService.registerUser("1234", "jenny", "1234"));		

	}
	
	

}
