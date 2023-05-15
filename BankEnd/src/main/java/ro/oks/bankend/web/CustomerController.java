package ro.oks.bankend.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.oks.bankend.dtos.CustomerDTO;
import ro.oks.bankend.mappers.CustomerMapper;
import ro.oks.bankend.model.Customer;
import ro.oks.bankend.repositories.CustomerRepository;
import ro.oks.bankend.web.interfacesWeb.CustomerApiInterface;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController implements CustomerApiInterface {
    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getCustomers(){
        return customerRepository.findAll().stream()
                .map(customer -> CustomerMapper.convertToCustomerDTO(customer)).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomer(@PathVariable String id) {
        Customer customer  = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error, customer not found"));
        return CustomerMapper.convertToCustomerDTO(customer);
    }

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public CustomerDTO updateCustomer(String customerId) {
        return null;
    }

    @Override
    public void deleteCustomer(String customerId) {

    }

}
