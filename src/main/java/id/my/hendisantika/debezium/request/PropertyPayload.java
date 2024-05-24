package id.my.hendisantika.debezium.request;

import ch.qos.logback.core.model.PropertyModel;
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
public class PropertyPayload {
    private String op;
    private PropertyModel before;
    private PropertyModel after;
}
