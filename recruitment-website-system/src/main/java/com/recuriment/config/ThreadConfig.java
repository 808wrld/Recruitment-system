package com.recuriment.config;

import cn.hutool.core.collection.ListUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 异步线程池的配置 与{@code @Async}注解一起使用
 *
 * @Author 大可爱李优秀
 * @Date 2019/11/8 13:39
 **/
@Configuration
@EnableAsync
public class ThreadConfig {


    @Value("${threadpool.core.pool.size}")
    private Integer corePoolSize;
    @Value("${threadpool.max.pool.size}")
    private Integer maxPoolSize;
    @Value("${threadpool.queue.capacity}")
    private Integer QueueCapacity;
    @Value("${threadpool.keep.alive.seconds}")
    private Integer keepAliveSeconds;

    @Bean("threadPool")
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize(corePoolSize);
        // 设置最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        // 设置队列容量
        executor.setQueueCapacity(QueueCapacity);
        // 设置线程活跃时间（秒）
        executor.setKeepAliveSeconds(keepAliveSeconds);
        // 设置默认线程名称
        executor.setThreadNamePrefix("order-thread");
        // 设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
