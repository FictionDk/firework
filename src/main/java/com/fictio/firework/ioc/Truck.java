package com.fictio.firework.ioc;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
@Setter
@ToString
public class Truck {
    private String driver;
    private String number;
    @SuppressWarnings("unused")
    public void init(){
        log.debug("Truck[{}] Init",number);
    }
    @SuppressWarnings("unused")
    public void inferred(){
        log.debug("Truck[{}] inferred",number);
    }

}
