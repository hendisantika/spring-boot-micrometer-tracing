package id.my.hendisantika.micrometertracing.config;

import io.micrometer.context.ContextExecutorService;
import io.micrometer.context.ContextSnapshot;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

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
@Configuration(proxyBeanMethods = false)
public class AsyncTraceContextConfig implements AsyncConfigurer {

    private final ThreadPoolTaskExecutor taskExecutor;

    AsyncTraceContextConfig(ThreadPoolTaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    @Override
    public Executor getAsyncExecutor() {
        return ContextExecutorService.wrap(
                taskExecutor.getThreadPoolExecutor(), ContextSnapshot::captureAll);
    }

}
