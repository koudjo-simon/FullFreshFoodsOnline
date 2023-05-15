package ro.oks.bankend.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.oks.bankend.dtos.FoodDTO;
import ro.oks.bankend.mappers.FoodMapper;
import ro.oks.bankend.repositories.FoodRepository;
import ro.oks.bankend.web.interfacesWeb.FoodApiInterface;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FoodController implements FoodApiInterface {

    @Override
    public List<FoodDTO> getFoods() {
        return null;
    }

    @Override
    public FoodDTO getFood(String foodId) {
        return null;
    }

    @Override
    public FoodDTO addFood(FoodDTO foodDTO) {
        return null;
    }

    @Override
    public FoodDTO updateFood(String foodId, FoodDTO foodDTO) {
        return null;
    }

    @Override
    public void deleteFood(String foodId) {

    }
}
