package id.my.hendisantika.debezium.service;

import id.my.hendisantika.debezium.request.PropertyListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-debezium-kafka-mysql-redis-cacheable
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/25/24
 * Time: 06:19
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class DebeziumListener {

    private final PropertyCacheService propertyCacheService;

    @KafkaListener(topics = "property.debezium.debezium_property", containerFactory = "kafkaListenerDebezium", groupId = "kafkaListenerDebezium")
    public void debeziumListener(@Payload(required = false) PropertyListener message) {
        try {
            if (message.getPayload().getOp().equals("c")) {
                propertyCacheService.cacheProperty(message.getPayload().getAfter().getProperty_key(),
                        message.getPayload().getAfter().getProperty_value());
            } else if (message.getPayload().getOp().equals("u")) {
                propertyCacheService.cacheEvict(message.getPayload().getBefore().getProperty_key());
                propertyCacheService.cacheProperty(message.getPayload().getAfter().getProperty_key(),
                        message.getPayload().getAfter().getProperty_value());
            } else {
                // do nothing
            }
            log.info(message.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
