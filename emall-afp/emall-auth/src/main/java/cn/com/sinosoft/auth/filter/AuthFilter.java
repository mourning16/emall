package cn.com.sinosoft.auth.filter;

import com.alibaba.dubbo.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

/**
 * @Description TODO
 * @Author Mourning 16
 * @Date 2020/11/12 13:59
 * @Version 1.0
 * <p>
 * dubbo的自激活特性
 */
@Slf4j
@Activate(group = {Constants.CONSUMER, Constants.PROVIDER}, order = -3000)
public class AuthFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        log.info("是否为生产者：" + RpcContext.getContext().isProviderSide());

        return invoker.invoke(invocation);

    }
}
