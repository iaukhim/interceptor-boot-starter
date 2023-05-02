package com.senla.iaukhim.interceptorbootstarter.config;

import com.senla.iaukhim.interceptorbootstarter.interceptor.DefaultInterceptor;
import com.senla.iaukhim.interceptorbootstarter.interceptor.Interceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Interceptor.class)
public class InterceptorConfig {

    @Bean
    @ConditionalOnMissingBean
    public Interceptor defaultInterceptor(){
        return new DefaultInterceptor();
    }

    @Bean
    public FilterRegistrationBean<Interceptor> defaultInterceptorRegistrationBean(){
        FilterRegistrationBean<Interceptor> interceptorFilterRegistrationBean = new FilterRegistrationBean<>();
        interceptorFilterRegistrationBean.setFilter(defaultInterceptor());
        interceptorFilterRegistrationBean.setOrder(Integer.MIN_VALUE);
        return interceptorFilterRegistrationBean;
    }
}

