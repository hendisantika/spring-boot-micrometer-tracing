package id.my.hendisantika.micrometertracing.controller;

import id.my.hendisantika.micrometertracing.dto.CustomerDTO;
import id.my.hendisantika.micrometertracing.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-micrometer-tracing
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/25/24
 * Time: 07:05
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public CustomerDTO getCustomer() {
        log.info("API Request to get customer");
        return customerService.getCustomer();
    }

    @GetMapping("/async")
    public String executeAsync() {
        log.info("API Request before Async method call");
        customerService.executeAsync();
        log.info("API Request after Async method call");
        return "Request accepted";
    }
}
