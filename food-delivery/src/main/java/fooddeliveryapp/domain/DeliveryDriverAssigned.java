package fooddeliveryapp.domain;

import fooddeliveryapp.domain.*;
import fooddeliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryDriverAssigned extends AbstractEvent {

    private String orderId;
    private String deliveryDriverId;

    public DeliveryDriverAssigned(DeliveryOrder aggregate) {
        super(aggregate);
    }

    public DeliveryDriverAssigned() {
        super();
    }
}
//>>> DDD / Domain Event
