package com.fictio.firework.ioc;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Log4j2
@Getter
@Component
public class RepairShop {
    private final Truck toolTruck;
    private final Truck transTruck;
    @SuppressWarnings("unused")
    public RepairShop(@Qualifier("secondTruck")Truck toolTruck,Truck transTruck){
        log.debug("Get tool toolTruck = {}, transTruck={}",toolTruck,transTruck);
        this.toolTruck = toolTruck;
        this.transTruck = transTruck;
    }
}
