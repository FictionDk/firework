package com.fictio.firework.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TruckFactoryConfiguration {

    @Bean(initMethod = "init")
    @Scope("prototype")
    public Truck buildTruck(){
        Truck truck = new Truck();
        truck.setNumber("B10132");
        return truck;
    }
}
