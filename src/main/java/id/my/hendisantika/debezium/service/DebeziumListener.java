package id.my.hendisantika.debezium.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
}
