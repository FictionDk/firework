package com.fictio.firework.ioc;


import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring-core 提供ioc
 * spring-context 提供上下文
 * spring-expression 提供el表达式
 */
@Log4j2
public class DependDemo {

    public static void main(String[] args) {
        DependDemo demo = new DependDemo();
        demo.xmlBeanFactory();
        demo.annotatedBeanFactory(false);
    }

    /**
     * 通过 AnnotationConfigApplicationContext
     * @return ApplicationContext
     */
    private ApplicationContext scanBeansByName(){
        ApplicationContext context = new AnnotationConfigApplicationContext(CarToolboxByAnnotated.class,
                Hammer.class,Wrench.class,FwBeanPostProcessor.class,Car.class);
        return context;
    }

    /**
     * 通过 ClassPathXmlApplicationContext scan指定包下的注解
     * @return ApplicationContext
     */
    private ApplicationContext scanBeansByXml(){
        return new ClassPathXmlApplicationContext("context.xml");
    }

    private void annotatedBeanFactory(boolean byName){
        ApplicationContext context;
        if(byName) context = scanBeansByName();
        else context = scanBeansByXml();
        log.debug("{}",context.containsBean("carToolboxByAnnotated"));
        log.debug("{}",context.getBean(CarToolboxByAnnotated.class));
        log.debug("{}",context.containsBean("car"));
        Car car1 = context.getBean("car",Car.class);
        Car car2 = context.getBean("car",Car.class);
        log.debug("{}",context.isPrototype("car"));
        log.debug("{} | {}",car1.equals(car2), car1 == car2);
        car1.setName("car1");
        car2.setName("car2");
        log.debug("{} | {}",car1.equals(car2), car1 == car2);
        log.debug("truck={}",context.getBean(Truck.class));
    }

    private void xmlBeanFactory(){
        // 1. 加载classpath下的配置文件
        // 2. 懒加载,当getBean时才正在实例化对象
        // new XmlBeanFactory("xxx");
        // 3. 预加载,用ClassPath需要expression支持
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        log.debug("containsBean: {}",context.containsBean("carToolboxByXml"));

        CarToolboxByXml carToolbox;
        carToolbox = (CarToolboxByXml) context.getBean("carToolboxByXml");
        log.debug("GetBeanByName: {}",carToolbox);
        carToolbox = context.getBean(CarToolboxByXml.class);
        log.debug("GetBeanByName: {}",carToolbox);
    }
}
