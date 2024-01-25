package fooddeliveryapp.domain;

import fooddeliveryapp.domain.*;
import fooddeliveryapp.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderStatusUpdated extends AbstractEvent {

    private String orderId;
    private String status;
}
