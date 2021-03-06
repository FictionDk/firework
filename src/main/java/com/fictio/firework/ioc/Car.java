package com.fictio.firework.ioc;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@Scope("prototype")
@Data
public class Car {
    private String name;
    private boolean needHammer;
    private boolean needWrench;
    @SuppressWarnings("unused")
    public void init(){
        log.debug("Car[{}] init.",name);
    }
}
