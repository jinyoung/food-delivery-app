package fooddeliveryapp.infra;

import fooddeliveryapp.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/deliveryOrders")
@Transactional
public class DeliveryOrderController {

    @Autowired
    DeliveryOrderRepository deliveryOrderRepository;

    @RequestMapping(
        value = "deliveryOrders/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public DeliveryOrder assignDeliveryDriver(
        @PathVariable(value = "id") Long id,
        @RequestBody AssignDeliveryDriverCommand assignDeliveryDriverCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /deliveryOrder/assignDeliveryDriver  called #####"
        );
        Optional<DeliveryOrder> optionalDeliveryOrder = deliveryOrderRepository.findById(
            id
        );

        optionalDeliveryOrder.orElseThrow(() -> new Exception("No Entity Found")
        );
        DeliveryOrder deliveryOrder = optionalDeliveryOrder.get();
        deliveryOrder.assignDeliveryDriver(assignDeliveryDriverCommand);

        deliveryOrderRepository.save(deliveryOrder);
        return deliveryOrder;
    }

    @RequestMapping(
        value = "deliveryOrders/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public DeliveryOrder updateDeliveryStatus(
        @PathVariable(value = "id") Long id,
        @RequestBody UpdateDeliveryStatusCommand updateDeliveryStatusCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /deliveryOrder/updateDeliveryStatus  called #####"
        );
        Optional<DeliveryOrder> optionalDeliveryOrder = deliveryOrderRepository.findById(
            id
        );

        optionalDeliveryOrder.orElseThrow(() -> new Exception("No Entity Found")
        );
        DeliveryOrder deliveryOrder = optionalDeliveryOrder.get();
        deliveryOrder.updateDeliveryStatus(updateDeliveryStatusCommand);

        deliveryOrderRepository.save(deliveryOrder);
        return deliveryOrder;
    }
}
//>>> Clean Arch / Inbound Adaptor
