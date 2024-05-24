package id.my.hendisantika.debezium.service;

import id.my.hendisantika.debezium.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
