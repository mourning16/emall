package cn.com.sinosoft.util.commons;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description TODO
 * @Author Mourning 16
 * @Date 2020/12/29 17:37
 * @Version 1.0
 */
@Component
@Slf4j
public class GracefulDubboShutdownBean {

    private static final int SHUTDOWN_SLEEP_LONG = 10;

    @PostConstruct
    public void init(){
        log.info("dubbo优雅停机的bean初始化完成~~");
    }

    @PreDestroy
    public void gracefulDubboShutdownMethod() throws InterruptedException {

        log.info("dubbo graceful shutdown~~~");

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("调用JVM关闭前的钩子函数~~");
            }
        }));

        log.info("dubbo graceful shutdown over~~~");
    }
}
