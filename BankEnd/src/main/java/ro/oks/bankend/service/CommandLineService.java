package ro.oks.bankend.service;

import ro.oks.bankend.dtos.CommandLineDTO;
import ro.oks.bankend.service.interfacesService.CommandLineServiceInterface;

public class CommandLineService implements CommandLineServiceInterface {
    @Override
    public CommandLineDTO addCommandLine(String foodId, String commandId, double quantity) {

        return null;
    }
    @Override
    public CommandLineDTO updateCommandLine(String id, CommandLineDTO commandLineDTO) {
        return null;
    }
    @Override
    public void deleteCommandLine(String commandLineId) {

    }
}
