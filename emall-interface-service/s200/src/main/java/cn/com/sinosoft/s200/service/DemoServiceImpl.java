package cn.com.sinosoft.s200.service;

import cn.com.sinosoft.i200.model.DemoModel;
import cn.com.sinosoft.i200.service.DemoService;
import cn.com.sinosoft.s200.dao.RoleDao;
import cn.com.sinosoft.s200.entity.Role;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "0.0.1")
@Slf4j
public class DemoServiceImpl implements DemoService {

    @Autowired
    RoleDao roleDao;

    public DemoModel demoDubboMethod(){
        DemoModel demoModel = new DemoModel();
        demoModel.setSayHiStr("DemoDubboService Say: Hi~~");

        Role role =  roleDao.selectById(30);
        log.info(JSON.toJSONString(role));

        return demoModel;
    }

}
