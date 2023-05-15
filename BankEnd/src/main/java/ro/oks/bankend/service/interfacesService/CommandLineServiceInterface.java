package ro.oks.bankend.service.interfacesService;

import ro.oks.bankend.dtos.CommandLineDTO;

public interface CommandLineServiceInterface {
    CommandLineDTO addCommandLine(String foodId, String commandId, double quantity);
    CommandLineDTO updateCommandLine(String id, CommandLineDTO commandLineDTO);
    void deleteCommandLine(String commandLineId);
}
