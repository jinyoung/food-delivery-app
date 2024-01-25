package fooddeliveryapp.domain;

import fooddeliveryapp.domain.*;
import fooddeliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryStatusUpdated extends AbstractEvent {

    private String orderId;
    private String status;

    public DeliveryStatusUpdated(DeliveryOrder aggregate) {
        super(aggregate);
    }

    public DeliveryStatusUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
