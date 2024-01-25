package fooddeliveryapp.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class PlaceOrderCommand {

    private String orderId;
    private String userId;
    private String restaurantId;
    private String menuItem;
    private Payment paymentInfo;
}
