package id.my.hendisantika.debezium.request;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-debezium-kafka-mysql-redis-cacheable
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/25/24
 * Time: 06:17
 * To change this template use File | Settings | File Templates.
 */
@Data
public class PropertyModel {
    private Long id;
    private Long created_date;
    private String property_key;
    private String property_value;
}
