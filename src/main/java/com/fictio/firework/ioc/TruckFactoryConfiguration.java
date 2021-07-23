package com.fictio.firework.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;

@Order(1)
@Configuration
public class TruckFactoryConfiguration {

    @Order(10)
    @Bean(initMethod = "init",name = "benzTruck")
    @Scope("prototype")
    @Primary
    public Truck buildBenzTruck(){
        Truck truck = new Truck();
        truck.setNumber("B10001");
        return truck;
    }

    @Order(1)
    @Bean(name = "lamborghiniTruck")
    @Scope("prototype")
    public Truck buildSecondTruck(){
        Truck truck = new Truck();
        truck.setNumber("B10002");
        return truck;
    }
}
