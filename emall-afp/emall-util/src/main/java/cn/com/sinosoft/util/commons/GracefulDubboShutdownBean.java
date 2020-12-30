package cn.com.sinosoft.util.commons;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.common.utils.ConfigUtils;
import org.apache.dubbo.registry.support.AbstractRegistryFactory;
import org.apache.dubbo.rpc.Protocol;
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
    public void dracefulDubboShutdownMethod() throws InterruptedException {
        log.info("dubbo开始停机~~~");
        //1、关闭注册中心
        //具体实现见zkClient.close():com.alibaba.dubbo.registry.zookeeper.ZookeeperRegistry#destroy
        AbstractRegistryFactory.destroyAll();

        //2、Wait for registry notification
        //这一句是新版dubbo的关键改动之处。老版本没有这几行sleep的代码【请读者自行阅读老版本的源码】。默认10秒，可以通过 [dubbo.service.shutdown.wait] 配置
        try {
            Thread.sleep(SHUTDOWN_SLEEP_LONG * 1000);
        } catch (InterruptedException e) {
            log.warn("Interrupted unexpectedly when waiting for registry notification during shutdown process!");
        }

        //3、销毁所有的protocol
        ExtensionLoader<Protocol> loader = ExtensionLoader.getExtensionLoader(Protocol.class);
        for (String protocolName : loader.getLoadedExtensions()) {
            try {
                Protocol protocol = loader.getLoadedExtension(protocolName);
                if (protocol != null) {
                    protocol.destroy();
                }
            } catch (Throwable t) {
                log.warn(t.getMessage(), t);
            }
        }
        log.info("停机完成~~~");
    }

}
