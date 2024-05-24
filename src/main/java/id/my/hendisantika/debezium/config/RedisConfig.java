package id.my.hendisantika.debezium.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-debezium-kafka-mysql-redis-cacheable
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/25/24
 * Time: 06:23
 * To change this template use File | Settings | File Templates.
 */
@RequiredArgsConstructor
@Configuration
@EnableCaching
public class RedisConfig {
    private static final String API_PREFIX = "debezium";
    private static final String SEPARATOR = ":";
}
