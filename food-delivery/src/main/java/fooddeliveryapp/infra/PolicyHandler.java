package fooddeliveryapp.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fooddeliveryapp.config.kafka.KafkaProcessor;
import fooddeliveryapp.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DeliveryOrderRepository deliveryOrderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPlaced'"
    )
    public void wheneverOrderPlaced_DeliveryAcceptancePolicy(
        @Payload OrderPlaced orderPlaced
    ) {
        OrderPlaced event = orderPlaced;
        System.out.println(
            "\n\n##### listener DeliveryAcceptancePolicy : " +
            orderPlaced +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderStatusUpdated'"
    )
    public void wheneverOrderStatusUpdated_DeliveryStatusUpdatePolicy(
        @Payload OrderStatusUpdated orderStatusUpdated
    ) {
        OrderStatusUpdated event = orderStatusUpdated;
        System.out.println(
            "\n\n##### listener DeliveryStatusUpdatePolicy : " +
            orderStatusUpdated +
            "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
