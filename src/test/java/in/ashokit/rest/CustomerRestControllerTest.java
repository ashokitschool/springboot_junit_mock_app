package in.ashokit.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.ashokit.binding.Customer;
import in.ashokit.service.CustomerService;

@WebMvcTest(controllers = CustomerRestController.class)
public class CustomerRestControllerTest {

	@MockitoBean
	private CustomerService customerService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testSaveCustomer1() throws Exception {

		Customer c = new Customer();
		c.setId(101);
		c.setName("Ashok");
		c.setEmail("ashok.b@gmail.com");

		// defining mock obj method behaviour
		when(customerService.saveCutomer(any(Customer.class))).thenReturn(true);

		// convert customer obj data into json format
		ObjectMapper mapper = new ObjectMapper();
		String customerJson = mapper.writeValueAsString(c);
		
		// prepare post request with json data in request body
		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/customer")
																  .contentType("application/json")
																  .content(customerJson);
		
		// send request and verify response
		mockMvc.perform(req)
		       .andExpect(status().isCreated())
		       .andExpect(content().string("Customer Saved"));
		
	}
	
	@Test
	public void testSaveCustomer2() throws Exception {

		Customer c = new Customer();
		c.setId(101);
		c.setName("Ashok");
		c.setEmail("ashok.b@gmail.com");

		// defining mock obj method behaviour
		when(customerService.saveCutomer(any(Customer.class))).thenReturn(false);

		// convert customer obj data into json format
		ObjectMapper mapper = new ObjectMapper();
		String customerJson = mapper.writeValueAsString(c);
		
		// prepare post request with json data in request body
		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/customer")
																  .contentType("application/json")
																  .content(customerJson);
		
		// send request and verify response
		mockMvc.perform(req)
		       .andExpect(status().isInternalServerError())
		       .andExpect(content().string("Customer Not Saved"));
		
	}
}
