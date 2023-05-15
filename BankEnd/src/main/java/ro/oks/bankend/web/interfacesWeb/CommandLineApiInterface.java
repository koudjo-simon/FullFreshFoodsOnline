package ro.oks.bankend.web.interfacesWeb;

import org.springframework.web.bind.annotation.*;
import ro.oks.bankend.dtos.CommandLineDTO;
import ro.oks.bankend.web.interfacesWeb.utils.Constants;

import java.util.List;

public interface CommandLineApiInterface {

    String URL = "/commandLine";
    String ID = "/{commandLineId}";

    @PostMapping(Constants.BASE_URL + URL + "/add")
    List<CommandLineDTO> addCommandsLines(@RequestParam(name = "foodId") String foodId,
                                          @RequestParam(name = "commandId") String commandId,
                                          @RequestParam(name = "quantity") double quantity);

    @PutMapping(Constants.BASE_URL + URL + ID + "/update")
    CommandLineDTO updateCommandLine(@PathVariable String commandLineId,
                                     @RequestBody CommandLineDTO commandLineDTO);

    @DeleteMapping(Constants.BASE_URL + URL + ID + "/delete")
    void deleteCommandLine(@PathVariable String commandLineId);

}
