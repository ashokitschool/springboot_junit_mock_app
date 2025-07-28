package in.ashokit.service;

import org.springframework.stereotype.Service;

@Service
public class CalService {

	private int sum(int a, int b) {
		return a + b;
	}

	public static boolean isEven(int number) {
		return number % 2 == 0;
	}
}
