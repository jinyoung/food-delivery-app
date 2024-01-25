package fooddeliveryapp.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateOrderStatusCommand {

    private String orderId;
    private String status;
}
