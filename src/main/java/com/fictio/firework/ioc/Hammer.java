package com.fictio.firework.ioc;

import lombok.Data;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 锤子
 */
@Data
@Component
@Order(13)
public class Hammer {
    private String name;
}
