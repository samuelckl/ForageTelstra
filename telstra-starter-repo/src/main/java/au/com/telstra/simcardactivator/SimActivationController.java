package au.com.telstra.simcardactivator;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.telstra.database.Customer;
import au.com.telstra.database.CustomerRepository;

@RestController
public class SimActivationController {

    private final CustomerRepository repository;

    public SimActivationController(CustomerRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/actuate")
    // Created the POST api with /actuate and check request if having iccid and it
    // not null or empty and return reponse
    public Customer activateSim(@RequestBody SimActivationRequest request) {
        boolean isValid = request.getIccid() != null && !request.getIccid().isEmpty();

        //  This check if customer iccid is existed before saving new customer
        Customer existing = repository.findByIccid(request.getIccid());
        if (existing != null) {
            return new Customer(null, null, false);
        }

        // After checking if iccid is valid and create a new customer entity
        if (isValid) {
            Customer saved = repository.save(new Customer(
                    request.getIccid(),
                    request.getCustomerEmail(),
                    true));
            return saved;
        }

        // If its not valid, just return a null null with active: false
        return new Customer(null, null, false);
    }

    // This is to query the customer by id
    @GetMapping("/query")
    public CustomerResponse getCustomerBySimCardId(@RequestParam("simCardId") Long id) {
        Optional<Customer> result = repository.findById(id);

        if (result.isPresent()) {
            Customer customer = result.get();
            return new CustomerResponse(customer.getIccid(), customer.getCustomerEmail(), customer.isActive());
        }

        // If not found, return empty/inactive response or throw exception if preferred
        return new CustomerResponse(null, null, false);
    }
}