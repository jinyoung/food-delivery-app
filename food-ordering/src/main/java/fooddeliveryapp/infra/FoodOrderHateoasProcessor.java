package fooddeliveryapp.infra;

import fooddeliveryapp.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class FoodOrderHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<FoodOrder>> {

    @Override
    public EntityModel<FoodOrder> process(EntityModel<FoodOrder> model) {
        // model.add(
        //     Link.of(model.getRequiredLink("self").getHref() + "/").withRel("")
        // );

        return model;
    }
}
