package ro.oks.bankend.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.oks.bankend.dtos.CommandDTO;
import ro.oks.bankend.exceptions.CommandNotFoundException;
import ro.oks.bankend.exceptions.CustomerNotFoundException;
import ro.oks.bankend.mappers.CommandMapper;
import ro.oks.bankend.model.Command;
import ro.oks.bankend.model.Customer;
import ro.oks.bankend.model.model_utils.CommandStatus;
import ro.oks.bankend.repositories.CommandRepository;
import ro.oks.bankend.repositories.CustomerRepository;
import ro.oks.bankend.service.interfacesService.CommandServiceInterface;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class CommandService implements CommandServiceInterface {

    private final CommandRepository commandRepository;
    private final CustomerRepository customerRepository;

    public CommandService(CommandRepository commandRepository, CustomerRepository customerRepository) {
        this.commandRepository = commandRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CommandDTO> getCommands() {
        return commandRepository.findAll().stream()
                .map(CommandMapper::convertToCommandDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CommandDTO getCommand(String commandId) throws CommandNotFoundException {
        log.info("Getting command with id = "+commandId);
        return CommandMapper.convertToCommandDTO(new VerifyEntity().verifyCommand(commandId));
    }

    @Override
    public CommandDTO addCommand(String customerId, CommandDTO commandDTO) throws CustomerNotFoundException {
        log.info("Adding customer ...");
        // Recherche du client
        Customer customer = new VerifyEntity().verifyCustomer(customerId);
        Command command = new Command();
        Date date = new Date();
        command.setCommandId(UUID.randomUUID().toString());
        command.setCommandDate(date);
        command.setCustomer(customer);
        command.setCommandStatus(CommandStatus.CREATED);
        command.setTotalCommandPrice(0);
        command.setLastModifiedDate(date);
        return CommandMapper.convertToCommandDTO(commandRepository.save(command));
    }

    @Override
    public CommandDTO updateCommand(String commandId, CommandDTO commandDTO) throws CommandNotFoundException {
        log.info("updating command with id = "+commandId);
        new VerifyEntity().verifyCommand(commandId);
        return CommandMapper.convertToCommandDTO(
                commandRepository.save(CommandMapper.confertToCommand(commandDTO)));
    }

    @Override
    public void deleteCommand(String commandId) throws CommandNotFoundException {
        new VerifyEntity().verifyCommand(commandId);
        commandRepository.deleteById(commandId);
    }
}
