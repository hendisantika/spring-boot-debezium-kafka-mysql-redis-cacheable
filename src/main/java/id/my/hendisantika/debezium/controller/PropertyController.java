package id.my.hendisantika.debezium.controller;

import id.my.hendisantika.debezium.request.PropertyRequest;
import id.my.hendisantika.debezium.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-debezium-kafka-mysql-redis-cacheable
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/25/24
 * Time: 06:24
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/property")
public class PropertyController {

    private final PropertyService propertyService;

    @PostMapping()
    public ResponseEntity<?> createProperty(@RequestBody PropertyRequest propertyRequest) {
        propertyService.createProperty(propertyRequest.getPropertyKey(), propertyRequest.getPropertyValue());
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
