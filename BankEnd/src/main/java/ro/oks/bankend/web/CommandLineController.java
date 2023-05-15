package ro.oks.bankend.web;

import ro.oks.bankend.dtos.CommandLineDTO;
import ro.oks.bankend.web.interfacesWeb.CommandLineApiInterface;

import java.util.List;

public class CommandLineController implements CommandLineApiInterface {
    @Override
    public List<CommandLineDTO> addCommandsLines(List<CommandLineDTO> commandLineDTOS) {
        return null;
    }

    @Override
    public CommandLineDTO updateCommandLine(String commandLineId, CommandLineDTO commandLineDTO) {
        return null;
    }

    @Override
    public void deleteCommandLine(String commandLineId) {

    }
}
