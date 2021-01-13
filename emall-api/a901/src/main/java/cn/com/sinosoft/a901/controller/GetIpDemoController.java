package cn.com.sinosoft.a901.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description TODO
 * @Author Mourning 16
 * @Date 2020/11/18 15:50
 * @Version 1.0
 */
@RestController
public class GetIpDemoController {

    @Autowired
    HttpServletRequest req;

    @GetMapping(value="getIp")
    public String index() {
        String remoteAddr = req.getRemoteAddr();
        System.out.println(remoteAddr);
        return remoteAddr;
    }

}
