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
// @RequestMapping(value="/restaurantManagements")
@Transactional
public class RestaurantManagementController {

    @Autowired
    RestaurantManagementRepository restaurantManagementRepository;

    @RequestMapping(
        value = "restaurantManagements/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public RestaurantManagement updateRestaurantMenu(
        @PathVariable(value = "id") String id,
        @RequestBody UpdateRestaurantMenuCommand updateRestaurantMenuCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /restaurantManagement/updateRestaurantMenu  called #####"
        );
        Optional<RestaurantManagement> optionalRestaurantManagement = restaurantManagementRepository.findById(
            id
        );

        optionalRestaurantManagement.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        RestaurantManagement restaurantManagement = optionalRestaurantManagement.get();
        restaurantManagement.updateRestaurantMenu(updateRestaurantMenuCommand);

        restaurantManagementRepository.save(restaurantManagement);
        return restaurantManagement;
    }
}
//>>> Clean Arch / Inbound Adaptor
