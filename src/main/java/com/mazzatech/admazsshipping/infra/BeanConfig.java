package com.mazzatech.admazsshipping.infra;

import com.mazzatech.admazsshipping.core.interfaces.ShippingRepository;
import com.mazzatech.admazsshipping.core.interfaces.ShippingService;
import com.mazzatech.admazsshipping.core.service.ShippingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    ShippingService shippingService(ShippingRepository shippingRepository){
        return new ShippingServiceImpl(shippingRepository);
    }
}
