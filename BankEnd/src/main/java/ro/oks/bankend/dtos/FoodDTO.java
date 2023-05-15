package ro.oks.bankend.dtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;
import org.aspectj.bridge.ICommand;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import ro.oks.bankend.model.model_utils.FoodStatus;

import java.util.Date;

@Data
public class FoodDTO {
    private String foodId;
    private String name;
    private Double price;
    private boolean favorite;
    private double star;
    private String tags;
    private String imageUrl;
    private String cookTIme;
    private String origins;
    private FoodStatus foodStatus;
    private Date addDate;
    private Date lastModifiedDate;
}
