package ro.oks.bankend.service.interfacesService;

import ro.oks.bankend.dtos.CommandLineDTO;
import ro.oks.bankend.exceptions.CommandLineNotFoundException;
import ro.oks.bankend.exceptions.CommandNotFoundException;
import ro.oks.bankend.exceptions.FoodNotFoodException;

public interface CommandLineServiceInterface {
    CommandLineDTO addCommandLine(String foodId, String commandId, double quantity) throws FoodNotFoodException, CommandNotFoundException;
    CommandLineDTO updateCommandLine(String commandLineId, CommandLineDTO commandLineDTO) throws CommandLineNotFoundException;
    void deleteCommandLine(String commandLineId) throws CommandLineNotFoundException;
}
