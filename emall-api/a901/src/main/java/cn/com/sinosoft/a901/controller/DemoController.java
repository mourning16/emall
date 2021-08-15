package cn.com.sinosoft.a901.controller;

import cn.com.sinosoft.i200.service.DemoService;
import cn.com.sinosoft.util.service.RedisServiceImpl;
import cn.com.sinosoft.util.utils.DateUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.imps.CuratorFrameworkState;
import org.apache.curator.retry.RetryNTimes;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@RestController
@Slf4j
public class DemoController {

    @Reference(version = "0.0.1")
    DemoService demoServiceImpl;

    @Autowired(required = false)
    RedisServiceImpl redisService;

    private static final String zkaddr =  "127.0.0.1:2181";

    @GetMapping("demo")
    public String demoMethod(){
        log.info("demo~~");
        return  DateUtil.dateToStr(new Date()) + "  时：a901对你说Say : Hi~~ ";
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
        System.out.println(st);
        return null;
    }

    @GetMapping("redisdemo")
    public String redisDemoMethod(String value){
        String key = "sayHi";
        redisService.set(key,value);
        log.info("~~~~~~~~~~~~" + value);
        return JSONObject.toJSONString(redisService.get(key));
    }

}
