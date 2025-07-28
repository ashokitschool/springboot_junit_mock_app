package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.Customer;
import in.ashokit.service.CustomerService;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/customer")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer customer) {
		
		boolean isSaved = customerService.saveCutomer(customer);
		
		if (isSaved) {
			return new ResponseEntity<>("Customer Saved", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Customer Not Saved", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
