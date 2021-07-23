
# spring-ioc

## 结构

### org.springframework.context
提供在基础IOC功能上的扩展服务，此外还提供许多企业级服务的支持，有邮件服务、任务调度、JNDI定位，EJB集成、远程访问、缓存以及多种视图层框架的支持。

### org.springframework.core
Spring以bean的方式组织和管理Java应用中的各个组件及其关系。它主要的组件就是BeanFactory,是工厂模式的实现。
同时BeanFactory适用控制反转（IOC） 思想将应用程序的配置和依赖性规范与实际的应用程序分开。

### org.springframework.expression
Spring表达式语言,类似`ClassPathXmlApplicationContext`对象需要

# Java-log

1. 日志接口: commons-logging,slf4j
2. 具体实现: log4j,log4j2,logback

## log4j2+lombok

> log4j-core+lombok+log4j2.xml

# 整理

## BeanFactory 和 ApplicationContext 的不同点

### BeanFactory(core)
1. 用来访问Spring容器的root接口,读取Bean配置,管理bean加载、实例化、生命周期、相互依赖;
2. 懒加载
3. 支持BeanFactoryPostProcessor和BeanPostProcessor,需手动注册

### ApplicationContext(context)
1. Spring应用程序中的中央接口,继承了BeanFactory(通过ListableBeanFactory);
2. 继承
   - EnvironmentCapable
   - ListableBeanFactory
   - HierarchicalBeanFactory
   - MessageSource 国际化
   - ApplicationEventPublisher 事件
   - ResourcePatternResolver 资源
3. 默认预加载(单例)
4. 支持BeanFactoryPostProcessor和BeanPostProcessor,自动注册

## 如何实现非单例
1. xml方式在bean标签内Scope属性改为:prototype
2. 注解方式在类上面新增`@Scope("prototype")`注解

## 使用Spring容器管理对象的方法
1. bean.xml,通过`XmlApplicationContext.beans.bean`加载bean
2. context.xml,通过`XmlApplicationContext.context.component-scan`加载包扫描管理
3. annotation,通过`AnnotationConfigApplicationContext(...)`加载需要管理的类对象
4. 涉及的注解:
   - Configuration
   - Bean 方法级别,
   - Component
   - Controller
   - Service
   - Repository
   - Autowired: 方法和类,
   - Qualifier

## DI
### 实例创建过程[By注解]
1. spring所需的对象,如:`xxxConfiguration/EventListener/.../AnnotationProcessor`
2. 自定义的PostProcessor
3. carToolboxByAnnotated(构造函数)等待
4. hammer(toolbox依赖)完成
5. wrench(toolbox依赖)完成
6. toolbox注入hammer和wrench
7. toolbox自定义BeanPostProcessor.before
8. toolbox.PostConstruct执行
9. toolbox自定义BeanPostProcessor.after

### Toolbox实例化过程[默认]
1. Toolbox()
2. 创建依赖对象,使用动态代理注入对象
3. BeanPostProcessor.before()
4. Toolbox.@PostConstruct()
5. BeanPostProcessor.after()

# 引用

> https://www.baeldung.com/spring-application-context