package fooddeliveryapp.domain;

import fooddeliveryapp.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "foodOrders",
    path = "foodOrders"
)
public interface FoodOrderRepository
    extends PagingAndSortingRepository<FoodOrder, String> {}
