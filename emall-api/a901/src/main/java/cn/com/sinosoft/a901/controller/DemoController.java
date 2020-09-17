package cn.com.sinosoft.a901.controller;

import cn.com.sinosoft.i200.service.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Reference(version = "0.0.1")
    DemoService demoServiceImpl;

    @GetMapping("demo")
    public String demoMethod(){
        return "a901对你说Say : Hi~~ ";
    }

    @GetMapping("dubbodemo")
    public String dubboDemoMethod(){
        return demoServiceImpl.demoDubboMethod().getSayHiStr();
    }
}
