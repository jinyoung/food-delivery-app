package fooddeliveryapp.domain;

import fooddeliveryapp.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "restaurantManagements",
    path = "restaurantManagements"
)
public interface RestaurantManagementRepository
    extends PagingAndSortingRepository<RestaurantManagement, String> {}
