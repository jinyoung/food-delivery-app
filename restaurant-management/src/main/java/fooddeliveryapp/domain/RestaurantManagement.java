package fooddeliveryapp.domain;

import fooddeliveryapp.RestaurantManagementApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "RestaurantManagement_table")
@Data
//<<< DDD / Aggregate Root
public class RestaurantManagement {

    @Id
    private String restaurantId;

    private String restaurantName;

    private String menu;

    private String orderHistory;

    @PrePersist
    public void onPrePersist() {}

    public static RestaurantManagementRepository repository() {
        RestaurantManagementRepository restaurantManagementRepository = RestaurantManagementApplication.applicationContext.getBean(
            RestaurantManagementRepository.class
        );
        return restaurantManagementRepository;
    }

    //<<< Clean Arch / Port Method
    public void updateRestaurantMenu(
        UpdateRestaurantMenuCommand updateRestaurantMenuCommand
    ) {
        //implement business logic here:

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
