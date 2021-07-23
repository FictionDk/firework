package com.fictio.firework.ioc;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * 汽车工具箱
 */
@Data
@Configuration
public class CarToolboxByAnnotated {
    private String name;
    @Autowired
    private Hammer hammer;
    @Autowired
    private Wrench wrench;
}
