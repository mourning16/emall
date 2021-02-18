package cn.com.sinosoft.a901.controller;

import cn.com.sinosoft.i200.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.imps.CuratorFrameworkState;
import org.apache.curator.retry.RetryNTimes;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DemoController {

    @Reference(version = "0.0.1")
    DemoService demoServiceImpl;

    private static final String zkaddr =  "127.0.0.1:2181";

    @GetMapping("demo")
    public String demoMethod(){
        log.info("demo~~");
        return "a901对你说Say : Hi~~ ";
    }

    @GetMapping("dubbodemo")
    public String dubboDemoMethod(){
        return demoServiceImpl.demoDubboMethod().getSayHiStr();
    }

    @GetMapping("zkConfig")
    public String zkConfig(){
        CuratorFramework client = CuratorFrameworkFactory
                .newClient(zkaddr, 1000*60, 1000*15, new RetryNTimes(10,5000));
        client.start();

        CuratorFrameworkState st = client.getState();
        return null;
    }

}
