package cn.com.sinosoft.s200.service;

import cn.com.sinosoft.i200.model.DemoModel;
import cn.com.sinosoft.i200.service.DemoService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "0.0.1")
public class DemoServiceImpl implements DemoService {

    public DemoModel demoDubboMethod(){
        DemoModel demoModel = new DemoModel();
        demoModel.setSayHiStr("DemoDubboService Say: Hi~~");
        return demoModel;
    }

}
