package id.my.hendisantika.debezium.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.my.hendisantika.debezium.request.PropertyListener;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-debezium-kafka-mysql-redis-cacheable
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/25/24
 * Time: 06:21
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableKafka
@AllArgsConstructor
@NoArgsConstructor
public class KafkaConsumerConfig {

    private String kafkaBootstrap = "localhost:29092";

    @Bean
    public ConsumerFactory<String, PropertyListener> consumerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrap);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "consumerFactory");
        config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, customizedJsonDeserializer());

        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), customizedJsonDeserializer());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, PropertyListener> kafkaListenerDebezium() {
        ConcurrentKafkaListenerContainerFactory<String, PropertyListener> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    private JsonDeserializer<PropertyListener> customizedJsonDeserializer() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        JsonDeserializer<PropertyListener> deserializer = new JsonDeserializer<>(PropertyListener.class, objectMapper);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);

        return deserializer;
    }
}
