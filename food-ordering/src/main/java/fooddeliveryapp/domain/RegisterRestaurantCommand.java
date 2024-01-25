package fooddeliveryapp.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RegisterRestaurantCommand {

    private String restaurantId;
    private String restaurantName;
    private String menu;
    private String operatingHours;
}
