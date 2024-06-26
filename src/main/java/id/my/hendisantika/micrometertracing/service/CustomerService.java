package id.my.hendisantika.micrometertracing.service;

import id.my.hendisantika.micrometertracing.dto.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-micrometer-tracing
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/25/24
 * Time: 07:04
 * To change this template use File | Settings | File Templates.
 */
@Service
@Slf4j
public class CustomerService {
    public CustomerDTO getCustomer() {
        log.info("Service request to get customer");
        return new CustomerDTO("John Doe");
    }

    @Async
    public void executeAsync() {
        log.info("Start Async method");
        //do something
    }
}
