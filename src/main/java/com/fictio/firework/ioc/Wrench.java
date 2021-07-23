package com.fictio.firework.ioc;

import lombok.Data;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 扳手
 */
@Data
@Component
@Order(11)
public class Wrench {
    private String name;
}
