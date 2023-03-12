[TOC]

# SpringBoot

* Spring
* SpringMVC
* SpringBoot
* SpringCloud


## 1、SpringMVC常用注解 & SpringCloud常用注解

***1、SpringMVC常用注解***

* `@Controller`：该类标识为SpringMVC的控制器
* `@Service`：该类标识为服务层
* `@RequestMapping`： 映射请求URL和方法之间的关系
* `@RequestParam`：获取请求参数的值
* `@PathVariable`： 获取URL中的参数
* `@RequestBody`：获取请求体中的内容
* `@ResponseBody`：返回内容给客户端
* `@ModelAttribute`：绑定请求参数到model对象
* `@SessionAttribute`：绑定Session中的属性到Model对象
* `@Component`：将对象注册到容器

***2、SpringBoot常用注解***

* @SpringBootApplication：启动类的注解，标识该类为SpringBoot应用的入口
* @RestController：标识该类为restful风格的控制器，相当于@Controller和@ResponseBody组合注解
* @GetMapping：映射get请求的url
* @PostMapping：映射post请求的url
* @PutMapping：映射put请求的url
* @DeleteMapping：映射delete请求的url
* @Value：获取配置文件的属性值
* @ComponentScan：扫描组件，可以设置扫描的包路径
* @Configuration：标识一个类是配置类，可以定义bean
* @EnableAutoConfiguration：自动配置，SpringBoot根据类路径上的jar包自动装配Spring Bean
* @SpringBootConfiguration：标识为配置类

***3、SpringCloud常用注解***

* @SpringCloudApplication：@SpringBootApplication@EnableDiscoveryClient@EnableCircuitBreaker组合注解
* @EnableDiscoveryClient：启用服务发现功能
* @EnableCircuitBreaker：启用断路器功能
* @FeignClient：声明一个Feign客户端
* @EnableFeignClients：扫描并启用feign客户端
* @LoadBalance：开启负责均衡

## 2、Spring Bean的作用域

Spring Bean的作用域指的是一个Bean实例在应用程序中的生命周期和可见范围。

Spring Bean的生命周期包括Bean实例的创建、初始化、注入、使用、销毁等阶段。

Spring框架支持以下五种作用域：

* 1、`Singleton`：单例模式，全局只有一个Bean实例，由Spring容器负责管理。默认的作用域
* 2、`Prototype`：原型模式，每次请求都会创建一个新的Bean实例，不由Spring容器进行管理
* 3、`Request`：请求作用域，每次Http请求都会创建一个新的Bean实例，仅在当前Http请求内有效
* 4、`Session`：会话作用域，每次Http请求都会创建一个新的Bean实例，仅在当前会话内有效
* 5、`GlobalSession`：全局会话作用域

选择合适的作用域，可以避免内存浪费，减少开销，提高系统性能。

比如，Singleton 适用于无状态的Bean，Prototype 适用于需要被多个对象共享的状态Bean。

## 3、Spring循环依赖

## 4、拦截器和过滤器的区别

## 5、Spring5对Redis的使用

## 6、SpringMVC特性

### 6.1、IOC

### 6.2、AOP原理

## 7、Spring事务
### 7.1、Spring事务传播行为

Spring 事务传播行为是指在多个事务方法互相调用时，如何处理这些事务方法之间的事务关系的机制。

七种事务传播行为：

| 事务传播行为类型 | 说明                                                         |
| ---------------- | ------------------------------------------------------------ |
| REQUIRED         | 如果当前没有事务，就新建一个事务，如果已经存在一个事务，加入到这个事务中。 |
| SUPPORTS         | 支持当前事务，如果当前没有事务，就以非事务方式执行。         |
| MANDATORY        | 使用当前的事务，如果当前没有事务，就抛出异常。               |
| REQUIRES_NEW     | 新建事务，如果当前存在事务，把当前事务挂起                   |
| NOT_SUPPORTED    | 以非事务方式执行操作，如果当前存在事务，则把当前事务挂起     |
| NEVER            | 以非事务方式执行，如果当前存在事务，则抛出异常               |
| NESTED           | 如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与REQUIRED类似的操作 |

* 需要注意的是：事务传播行为只在多个事务方法之间相互调用时才会生效，如果只有一个事务方法，则没有事务传播的意义。

### 7.2、Spring事务原理

Spring事务传播行为的实现原理涉及到Spring AOP和Spring 事务管理器两部分内容。

首先，当一个方法别标记为`@Trancactional`注解时，Spring会使用AOP生成一个代理类，并在代理类中对该方法进行增强，在方法的前后分别添加事务处理相关代码。代理类会继承目标类的接口，并在运行时动态实现目标方法，具体实现方式可以使JDK动态代理或CGLIB代理。

其次，Spring 事务管理器通过拦截器的方式将代理类的方法封装成一个事务，管理该事务的生命周期和一些细节，比如事务的隔离级别和回滚规则。当方法被调用时，Spring事务管理器会判断当前是否有已经开启的事务，并根据方法标记的事务传播行为和已有事务的情况来决定是否开启新事务、加入已有事务或者以非事务方式执行。在事务执行结束时，根据事务执行的结果，决定是否提交事务或者回滚事务。

总体来说，Spring事务传播行为的实现原理是通过AOP生成代理类，在代理类中对目标方法进行增强，并在代理类中调用事务管理器来管理事务的生命周期和执行过程。