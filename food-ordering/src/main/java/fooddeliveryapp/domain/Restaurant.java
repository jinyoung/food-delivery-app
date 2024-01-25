package fooddeliveryapp.domain;

import fooddeliveryapp.FoodOrderingApplication;
import fooddeliveryapp.domain.RestaurantRegistered;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Restaurant_table")
@Data
//<<< DDD / Aggregate Root
public class Restaurant {

    @Id
    private String restaurantId;

    private String restaurantName;

    private String menu;

    private String operatingHours;

    @PostPersist
    public void onPostPersist() {
        RestaurantRegistered restaurantRegistered = new RestaurantRegistered(
            this
        );
        restaurantRegistered.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static RestaurantRepository repository() {
        RestaurantRepository restaurantRepository = FoodOrderingApplication.applicationContext.getBean(
            RestaurantRepository.class
        );
        return restaurantRepository;
    }
}
//>>> DDD / Aggregate Root
