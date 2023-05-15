package ro.oks.bankend.service;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ro.oks.bankend.exceptions.CommandNotFoundException;
import ro.oks.bankend.exceptions.CustomerNotFoundException;
import ro.oks.bankend.exceptions.FoodNotFoodException;
import ro.oks.bankend.model.Command;
import ro.oks.bankend.model.Customer;
import ro.oks.bankend.model.Food;
import ro.oks.bankend.repositories.CommandLineRepository;
import ro.oks.bankend.repositories.CommandRepository;
import ro.oks.bankend.repositories.CustomerRepository;
import ro.oks.bankend.repositories.FoodRepository;

@Slf4j
@NoArgsConstructor(force = true)
public class VerifyEntity {

    private final FoodRepository foodRepository;
    private final CustomerRepository customerRepository;
    private final CommandRepository commandRepository;
    private final CommandLineRepository commandLineRepository;

    protected VerifyEntity(FoodRepository foodRepository,
                        CustomerRepository customerRepository,
                        CommandRepository commandRepository,
                        CommandLineRepository commandLineRepository) {
        this.foodRepository = foodRepository;
        this.customerRepository = customerRepository;
        this.commandRepository = commandRepository;
        this.commandLineRepository = commandLineRepository;
    }

    protected Food verifyFood(String foodId) throws FoodNotFoodException {
        log.info("Checking food with id = " + foodId);
        Food food = foodRepository.findById(foodId)
                .orElseThrow(() -> new FoodNotFoodException("Food with id = "+foodId+" not Found"));
        return food;
    }

    protected Customer verifyCustomer(String customerId) throws CustomerNotFoundException {
        log.info("Checking customer with id = "+customerId);
        Customer customer = customerRepository
                .findById(customerId).orElseThrow(
                        () -> new CustomerNotFoundException("Customer with id = "+customerId+" is not found")
                );
        return customer;
    }

    protected Command verifyCommand(String commandId) throws CommandNotFoundException {
        return commandRepository.findById(commandId)
                .orElseThrow(
                        () -> new CommandNotFoundException("Command with id = "+commandId+" not found")
                );
    }

}
