package ro.oks.bankend.web;

import ro.oks.bankend.dtos.CommandDTO;
import ro.oks.bankend.web.interfacesWeb.CommandApiInterface;

import java.util.List;

public class CommandController implements CommandApiInterface {
    @Override
    public List<CommandDTO> getCommands() {
        return null;
    }

    @Override
    public CommandDTO getCommand(String commandId) {
        return null;
    }

    @Override
    public CommandDTO addCommand(String customerId) {
        return null;
    }

    @Override
    public CommandDTO updateCommand(String commandId, CommandDTO commandDTO) {
        return null;
    }

    @Override
    public void deleteCommand(String commandId) {

    }
}
