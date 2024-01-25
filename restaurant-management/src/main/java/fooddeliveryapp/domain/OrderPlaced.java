package fooddeliveryapp.domain;

import fooddeliveryapp.domain.*;
import fooddeliveryapp.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private String orderId;
    private String userId;
    private String restaurantId;
    private String menuItem;
    private Object paymentInfo;
}
