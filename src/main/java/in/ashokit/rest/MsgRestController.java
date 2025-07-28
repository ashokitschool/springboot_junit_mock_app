package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.service.MsgService;

@RestController
public class MsgRestController {

	@Autowired
	private MsgService msgService;

	@GetMapping("/welcome")
	public String welcomeMsg() {

		msgService.sendEmail();

		String welcomeMsg = msgService.getWelcomeMsg();

		String formattedMsg = null;

		if (welcomeMsg != null && !welcomeMsg.equals("")) {
			formattedMsg = welcomeMsg.toUpperCase();
		}

		return formattedMsg;
	}

}
