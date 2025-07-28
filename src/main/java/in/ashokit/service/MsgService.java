package in.ashokit.service;

import org.springframework.stereotype.Service;

@Service
public class MsgService {

	public String getWelcomeMsg() {
		String msg = "Welcome to Ashok IT";
		return msg;
	}

	public void sendEmail() {
		System.out.println("sendEmail() real method called.......");
		// logic
	}

	public String getGreetMsg() {
		String msg = "Good Mrng..!!";
		return msg;
	}

	public String wish(String name) {
		if (name.equals("Raju")) {
			return "Hey raju";
		} else if (name.equals("Rani")) {
			return "Hello, Rani";
		} else {
			return null;
		}
	}
}
