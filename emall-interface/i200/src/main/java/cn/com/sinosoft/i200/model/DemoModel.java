package cn.com.sinosoft.i200.model;

import java.io.Serializable;

public class DemoModel implements Serializable {

    private static final long serialVersionUID = -8752772819747562979L;

    private String sayHiStr;

    public String getSayHiStr() {
        return sayHiStr;
    }

    public void setSayHiStr(String sayHiStr) {
        this.sayHiStr = sayHiStr;
    }
}
