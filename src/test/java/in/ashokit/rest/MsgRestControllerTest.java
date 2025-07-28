package in.ashokit.rest;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import in.ashokit.service.MsgService;

@WebMvcTest(controllers = MsgRestController.class)
public class MsgRestControllerTest {

	@MockitoBean
	private MsgService msgService;

	@Autowired
	private MockMvc mockMvc; // to send http req for rest controller methods

	@Test
	public void testWelcomeMsg1() throws Exception {

		// defining mock obj void method behaviour
		doNothing().when(msgService).sendEmail();

		// defining mock obj method behaviour for unit testing
		when(msgService.getWelcomeMsg()).thenReturn("Dummy Text");

		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/welcome");

		MvcResult result = mockMvc.perform(req).andReturn();

		MockHttpServletResponse response = result.getResponse();

		// String contentAsString = response.getContentAsString();

		int actualStatus = response.getStatus();

		Assertions.assertEquals(200, actualStatus);
	}

	@Test
	public void testWelcomeMsg2() throws Exception {

		// defining mock obj void method behaviour
		doNothing().when(msgService).sendEmail();

		// defining mock obj method behaviour for unit testing
		when(msgService.getWelcomeMsg()).thenReturn(null);

		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/welcome");

		MvcResult result = mockMvc.perform(req).andReturn();

		MockHttpServletResponse response = result.getResponse();

		// String contentAsString = response.getContentAsString();

		int actualStatus = response.getStatus();

		Assertions.assertEquals(200, actualStatus);
	}

	@Test
	public void testWelcomeMsg3() {

		// defining mock obj void method behaviour
		doNothing().when(msgService).sendEmail();

		// defining mock obj method behaviour for unit testing
		when(msgService.getWelcomeMsg()).thenThrow(RuntimeException.class);

		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/welcome");

		try {
			mockMvc.perform(req).andExpect(status().isInternalServerError())
					.andExpect(content().string("Exception Occured"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
