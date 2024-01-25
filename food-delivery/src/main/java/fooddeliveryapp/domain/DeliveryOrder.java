package fooddeliveryapp.domain;

import fooddeliveryapp.FoodDeliveryApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DeliveryOrder_table")
@Data
//<<< DDD / Aggregate Root
public class DeliveryOrder {

    @Id
    private String orderId;

    private String userId;

    private String restaurantId;

    private String status;

    private statusType statusType;

    private String deliveryDriverId;

    @PrePersist
    public void onPrePersist() {}

    public static DeliveryOrderRepository repository() {
        DeliveryOrderRepository deliveryOrderRepository = FoodDeliveryApplication.applicationContext.getBean(
            DeliveryOrderRepository.class
        );
        return deliveryOrderRepository;
    }

    //<<< Clean Arch / Port Method
    public void assignDeliveryDriver(
        AssignDeliveryDriverCommand assignDeliveryDriverCommand
    ) {
        //implement business logic here:

        DeliveryDriverAssigned deliveryDriverAssigned = new DeliveryDriverAssigned(
            this
        );
        deliveryDriverAssigned.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void updateDeliveryStatus(
        UpdateDeliveryStatusCommand updateDeliveryStatusCommand
    ) {
        //implement business logic here:

        DeliveryStatusUpdated deliveryStatusUpdated = new DeliveryStatusUpdated(
            this
        );
        deliveryStatusUpdated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
