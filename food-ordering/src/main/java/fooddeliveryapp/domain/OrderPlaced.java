package fooddeliveryapp.domain;

import fooddeliveryapp.domain.*;
import fooddeliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private String orderId;
    private String userId;
    private String restaurantId;
    private String menuItem;
    private Payment paymentInfo;

    public OrderPlaced(FoodOrder aggregate) {
        super(aggregate);
    }

    public OrderPlaced() {
        super();
    }
}
//>>> DDD / Domain Event
