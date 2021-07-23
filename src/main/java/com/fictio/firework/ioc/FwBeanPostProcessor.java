package com.fictio.firework.ioc;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;


@Configuration
@Log4j2
public class FwBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.debug("Before {} : {}",beanName,bean);
        if(bean instanceof Wrench){
            Wrench wrench = (Wrench) bean;
            wrench.setName("扳手ByProcessBefore");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.debug("After {} : {}",beanName,bean);
        if(bean instanceof Hammer){
            Hammer hammer = (Hammer) bean;
            hammer.setName("大锤ByProcessAfter");
        }
        return bean;
    }
}
