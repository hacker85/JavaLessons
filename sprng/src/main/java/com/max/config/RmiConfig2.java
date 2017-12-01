package com.max.config;

import com.max.interfaces.RmiService;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

//@Configuration
public class RmiConfig2 {
    @Bean
    public RmiProxyFactoryBean proxyFactoryBean() {
        RmiProxyFactoryBean bean = new RmiProxyFactoryBean();
        bean.setServiceUrl("rmi://localhost/rmiServiceName");
        bean.setServiceInterface(RmiService.class);
        return bean;
    }
}
