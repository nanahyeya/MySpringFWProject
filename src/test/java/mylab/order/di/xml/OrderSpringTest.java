package mylab.order.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {
	
	@Autowired
	ShoppingCart shoppingCart;
	
	@Autowired
	OrderService orderService;
	
	@Test
	void testshoppingcart() {
		assertNotNull(shoppingCart);
		assertEquals(2, shoppingCart.getProducts().size());
		assertEquals("product1", shoppingCart.getProducts().get(0).getName());
		assertEquals("product2", shoppingCart.getProducts().get(1).getName());

	}
	
	@Test
	void testorderservice() {
		assertNotNull(orderService);
		assertEquals(shoppingCart, orderService.getShoppingCart());
		assertEquals(2, orderService.getShoppingCart().getProducts().size());
		assertEquals(6000, orderService.calculateOrderTotal());
	}
	

}
