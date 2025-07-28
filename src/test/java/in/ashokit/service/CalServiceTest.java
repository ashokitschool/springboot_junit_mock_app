package in.ashokit.service;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalServiceTest {

	@Test
	public void testPrivateMethod() throws Exception {

		CalService cal = new CalService();

		Method method = CalService.class.getDeclaredMethod("sum", int.class, int.class);
		method.setAccessible(true);

		int result = (int) method.invoke(cal, 20, 30);

		Assertions.assertEquals(50, result);

	}

	@Test
	public void testIsEven() {
		boolean iseven = CalService.isEven(10);
		Assertions.assertTrue(iseven);
	}

	@ParameterizedTest
	@ValueSource(ints = { 2, 4, 6, 8, 10, 11 })
	public void testEven(int num) {
		boolean iseven = CalService.isEven(num);
		Assertions.assertTrue(iseven);
	}

}
