package fooddeliveryapp.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateDeliveryStatusCommand {

    private String orderId;
    private String status;
}
