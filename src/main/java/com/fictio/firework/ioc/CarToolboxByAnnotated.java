package com.fictio.firework.ioc;

import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * 汽车工具箱
 */
@Log4j2
@ToString
@Configuration
public class CarToolboxByAnnotated {
    @SuppressWarnings("unused")
    private String name;
    @Autowired
    private Hammer hammer;
    @Autowired
    private Wrench wrench;
    public CarToolboxByAnnotated(){
        log.debug("Toolbox construct");
    }
    @PostConstruct
    private void postConstruct(){
        log.debug("Toolbox postConstruct");
        this.name = "Ann生成的工具箱";
    }
}
