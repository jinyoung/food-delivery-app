package fooddeliveryapp.domain;

import fooddeliveryapp.FoodOrderingApplication;
import fooddeliveryapp.domain.OrderPlaced;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "FoodOrder_table")
@Data
//<<< DDD / Aggregate Root
public class FoodOrder {

    @Id
    private String orderId;

    private String userId;

    private String restaurantId;

    private String menuItem;

    private Payment paymentInfo;

    private String status;

    private statusType statusType;

    private String deliveryDriverId;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static FoodOrderRepository repository() {
        FoodOrderRepository foodOrderRepository = FoodOrderingApplication.applicationContext.getBean(
            FoodOrderRepository.class
        );
        return foodOrderRepository;
    }

    //<<< Clean Arch / Port Method
    public void updateOrderStatus(
        UpdateOrderStatusCommand updateOrderStatusCommand
    ) {
        //implement business logic here:

        OrderStatusUpdated orderStatusUpdated = new OrderStatusUpdated(this);
        orderStatusUpdated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
