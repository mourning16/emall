package cn.com.sinosoft.a901.config;

import cn.com.sinosoft.a901.interceptor.SignatureInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description TODO
 * @Author Mourning 16
 * @Date 2020/10/10 9:59
 * @Version 1.0
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public SignatureInterceptor getSignatureInterceptor(){
        return new SignatureInterceptor();
    }

    /**
     * 注册拦截器
     *
     * @param registry registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getSignatureInterceptor())
                .addPathPatterns("/**");
    }
}
