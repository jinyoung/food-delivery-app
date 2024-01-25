package fooddeliveryapp.domain;

import fooddeliveryapp.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "deliveryOrders",
    path = "deliveryOrders"
)
public interface DeliveryOrderRepository
    extends PagingAndSortingRepository<DeliveryOrder, Long> {}
