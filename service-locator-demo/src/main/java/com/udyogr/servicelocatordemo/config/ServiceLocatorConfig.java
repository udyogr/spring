package com.udyogr.servicelocatordemo.config;

import com.udyogr.servicelocatordemo.service.PaymentRegistry;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceLocatorConfig {

    @Bean
    public FactoryBean<?> getBean() {
        ServiceLocatorFactoryBean bean = new ServiceLocatorFactoryBean();
        bean.setServiceLocatorInterface(PaymentRegistry.class);
        return bean;
    }

}
