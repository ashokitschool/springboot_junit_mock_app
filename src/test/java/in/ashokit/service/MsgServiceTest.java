package in.ashokit.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MsgServiceTest {

	@Autowired
	private MsgService msgService;

	@Test
	public void testWelcomeMsg() {

		// calling target method
		String welcomeMsg = msgService.getWelcomeMsg();

		// validating the result
		Assertions.assertEquals("Welcome to Ashok IT", welcomeMsg);
	}

	@Test
	public void testGreetMsg() {

		// call target method
		String greetMsg = msgService.getGreetMsg();

		// validate the result
		Assertions.assertNotNull(greetMsg);
	}

	@Test
	public void testWish1() {

		// call target method
		String wish = msgService.wish("Raju");

		// validate result
		Assertions.assertNotNull(wish);
	}

	@Test
	public void testWish2() {

		// call target method
		String wish = msgService.wish("John");

		// validate result
		Assertions.assertNull(wish);
	}
}
