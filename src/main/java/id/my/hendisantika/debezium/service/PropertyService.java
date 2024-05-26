package id.my.hendisantika.debezium.service;

import id.my.hendisantika.debezium.entity.Property;
import id.my.hendisantika.debezium.repository.PropertyRepository;
import id.my.hendisantika.debezium.request.PropertyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-debezium-kafka-mysql-redis-cacheable
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/25/24
 * Time: 06:20
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class PropertyService {

    private final PropertyRepository propertyRepository;

    public List<Property> listAllProperties() {
        return propertyRepository.findAll();
    }

    @Transactional
    public String createProperty(String key, String value) {
        Property property = Property.builder()
                .propertyKey(key)
                .propertyValue(value).build();
        return propertyRepository.save(property).getPropertyValue();
    }

    @Transactional
    public void updateProperty(PropertyRequest propertyRequest) {
        Property property = propertyRepository.findByPropertyKey(propertyRequest.getKey())
                .orElseThrow(() -> new RuntimeException("Property Not Found!"));

        property.setPropertyValue(propertyRequest.getValue());
        propertyRepository.save(property);
    }

    @Transactional
    @Cacheable(value = "property", cacheManager = "cacheManager", key = "#key")
    public String getProperty(String key) throws InterruptedException {
        Property property = propertyRepository.findByPropertyKey(key)
                .orElseThrow(() -> new RuntimeException("Property Not Found!"));

        Thread.sleep(1000);

        return property.getPropertyValue();
    }
}
