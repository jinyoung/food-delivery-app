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
// @RequestMapping(value="/foodOrders")
@Transactional
public class FoodOrderController {

    @Autowired
    FoodOrderRepository foodOrderRepository;

    @RequestMapping(
        value = "foodOrders/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public FoodOrder updateOrderStatus(
        @PathVariable(value = "id") Long id,
        @RequestBody UpdateOrderStatusCommand updateOrderStatusCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /foodOrder/updateOrderStatus  called #####");
        Optional<FoodOrder> optionalFoodOrder = foodOrderRepository.findById(
            id
        );

        optionalFoodOrder.orElseThrow(() -> new Exception("No Entity Found"));
        FoodOrder foodOrder = optionalFoodOrder.get();
        foodOrder.updateOrderStatus(updateOrderStatusCommand);

        foodOrderRepository.save(foodOrder);
        return foodOrder;
    }
}
//>>> Clean Arch / Inbound Adaptor
