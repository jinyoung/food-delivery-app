package fooddeliveryapp.infra;

import fooddeliveryapp.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class RestaurantManagementHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<RestaurantManagement>> {

    @Override
    public EntityModel<RestaurantManagement> process(
        EntityModel<RestaurantManagement> model
    ) {
        return model;
    }
}
