package fooddeliveryapp.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class AssignDeliveryDriverCommand {

    private String orderId;
    private String deliveryDriverId;
}
