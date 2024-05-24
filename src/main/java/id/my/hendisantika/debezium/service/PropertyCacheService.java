package id.my.hendisantika.debezium.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
public class PropertyCacheService {
    @Cacheable(value = "property", cacheManager = "cacheManager", key = "#key")
    public String cacheProperty(String key, String value) {
        return value;
    }

    @CacheEvict(value = "property", cacheManager = "cacheManager", key = "#key")
    public void cacheEvict(String key) {
    }
}
