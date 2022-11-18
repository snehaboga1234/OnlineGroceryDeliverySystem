package com.onlinegrocerydeliverysystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OnlineGroceryDeliverySystemApplicationTests {
	@Test
	void contextLoads() {
			String s="Everything is working fine";
		assertEquals("Everything is working fine",s);
	}

}
