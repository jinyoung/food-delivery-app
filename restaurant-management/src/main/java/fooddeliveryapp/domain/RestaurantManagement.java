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

    public void UpdateRestaurantMenu() {
        //
    }

    //<<< Clean Arch / Port Method
    public static void takeOrder(OrderPlaced orderPlaced) {
        //implement business logic here:

        /** Example 1:  new item 
        RestaurantManagement restaurantManagement = new RestaurantManagement();
        repository().save(restaurantManagement);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(restaurantManagement->{
            
            restaurantManagement // do something
            repository().save(restaurantManagement);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
