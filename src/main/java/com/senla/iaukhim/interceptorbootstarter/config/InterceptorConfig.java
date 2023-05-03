package com.senla.iaukhim.interceptorbootstarter.config;

import com.senla.iaukhim.interceptorbootstarter.interceptor.DefaultInterceptor;
import com.senla.iaukhim.interceptorbootstarter.interceptor.Interceptor;
import com.senla.iaukhim.interceptorbootstarter.repository.RequestInfoRepository;
import com.senla.iaukhim.interceptorbootstarter.service.RequestInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ConditionalOnClass(RestController.class)
@EnableTransactionManagement
@EnableMongoRepositories({"com.senla.iaukhim.interceptorbootstarter.repository"})
@ComponentScan(basePackages = "com.senla.iaukhim.interceptorbootstarter")
public class InterceptorConfig {

    @Autowired
    private RequestInfoRepository requestInfoRepository;

    @Autowired
    private RequestInfoService requestInfoService;


    @Bean
    @ConditionalOnMissingBean(Interceptor.class)
    public FilterRegistrationBean<Interceptor> defaultInterceptorRegistrationBean(){
        FilterRegistrationBean<Interceptor> interceptorFilterRegistrationBean = new FilterRegistrationBean<>();
        interceptorFilterRegistrationBean.setFilter(new DefaultInterceptor(requestInfoService));
        interceptorFilterRegistrationBean.setOrder(Integer.MIN_VALUE);
        return interceptorFilterRegistrationBean;
    }
}

