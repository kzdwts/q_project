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

* `@SpringBootApplication`：启动类的注解，标识该类为SpringBoot应用的入口
* `@RestController`：标识该类为restful风格的控制器，相当于@Controller和@ResponseBody组合注解
* `@GetMapping`：映射get请求的url
* `@PostMapping`：映射post请求的url
* `@PutMapping`：映射put请求的url
* `@DeleteMapping`：映射delete请求的url
* `@Value`：获取配置文件的属性值
* `@ComponentScan`：扫描组件，可以设置扫描的包路径
* `@Configuration`：标识一个类是配置类，可以定义bean
* `@EnableAutoConfiguration`：自动配置，SpringBoot根据类路径上的jar包自动装配Spring Bean
* `@SpringBootConfiguration`：标识为配置类

***3、SpringCloud常用注解***

* `@SpringCloudApplication`：组合注解
  * `@SpringBootApplication`
  * `@EnableDiscoveryClient`
  * `@EnableCircuitBreaker`

* `@EnableDiscoveryClient`：启用服务发现功能
* `@EnableCircuitBreaker`：启用断路器功能
* `@FeignClient`：声明一个`Feign`客户端
* `@EnableFeignClients`：扫描并启用feign客户端
* `@LoadBalance`：开启负载均衡

## 2、Spring Bean的作用域

`Spring Bean`的作用域指的是一个Bean实例在应用程序中的生命周期和可见范围。

`Spring Bean`的生命周期包括Bean实例的创建、初始化、注入、使用、销毁等阶段。

`Spring`框架支持以下五种作用域：

* 1、`Singleton`：单例模式，全局只有一个Bean实例，由Spring容器负责管理。默认的作用域
* 2、`Prototype`：原型模式，每次请求都会创建一个新的Bean实例，不由Spring容器进行管理
* 3、`Request`：请求作用域，每次Http请求都会创建一个新的Bean实例，仅在当前Http请求内有效
* 4、`Session`：会话作用域，每次Http请求都会创建一个新的Bean实例，仅在当前会话内有效
* 5、`GlobalSession`：全局会话作用域

选择合适的作用域，可以避免内存浪费，减少开销，提高系统性能。

比如，`Singleton `适用于无状态的Bean，`Prototype` 适用于需要被多个对象共享的状态Bean。

## 3、Spring循环依赖

Spring 通过三级缓存来解决循环依赖问题。

第一级缓存：singletonObjects，单例对象的缓存池，存储完整的Bean对象。

第二级缓存：earlySingletonObjects，早期单例对象的缓存池，存储未完成初始化的Bean对象。

第三级缓存：singletonFactories，提前曝光的Bean对象工厂的缓存池，存储用于创建单例对象的ObjectFactory对象。

当`Spring`在创建`Bean`的过程中发现循环依赖时，会在第一级缓存中查找当前的Bean对象是否已经存在。如果存在，则直接返回；如果不存在，则会先尝试从第二级缓存中获取早期的Bean对象，如果还没有则会使用第三级缓存中的`ObjectFactory`对象创建一个新的Bean对象，并将其存入到第二级缓存中，等待后续的处理。

在Bean对象创建完成后，`Spring`会将其存储到第一级缓存中，同时会将第二级缓存和第三级缓存中与之相关的数据清除，以便后续的依赖注入。

通过这种方式，`Spring`可以在创建`Bean`对象的过程中解决循环依赖的问题，同时还能保证单例对象的唯一性。

## 4、拦截器和过滤器的区别

区别：

* 1、定义与实现
  * 拦截器（Interceptor）
    * 基于框架层面的概念、例如Spring MVC的HandlerInterceptor
    * 基于框架的AOP（面向切面编程）的机制实现
    * 需要依赖框架的上下文环境
  * 过滤器（Filter）
    * 基于Servlet容器实现，独立于具体的框架
    * 不依赖任何框架即可使用
* 2、作用范围
  * 拦截器
    * 主要针对框架内的请求进行拦截，例如SpringMVC中的Controller层进行拦截。
    * 可以根据url路径、方法类型或注解进行精细化控制。
  * 过滤器
    * 针对所有进入Servlet的请求和响应进行拦截
    * 更底层，适用于全局性任务
* 3、执行顺序
  * 拦截器
    * 在请求到达Controller之前和之后执行
    * 提供三个主要方法：
      * `preHandle()`：请求处理前执行
      * `postHandle()`：视图渲染前执行
      * `afterCompletion()`：请求完成后
  * 过滤器
    * 在请求到达Servlet之前和响应返回客户端之前执行
    * 提供一个核心方法
      * `doFilter()`：用于处理请求和响应
* 4、依赖注入支持
  * 拦截器
    * 支持Spring的框架的依赖注入，可以直接访问框架中的Bean
  * 过滤器
    * 不直接支持依赖注入
    * 如果需要获取框架中的Bean，需要通过获取`ApplicationContext`等方式实现

应用场景对比：

| 特性         | 拦截器                                                       | 过滤器                                                       |
| ------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 业务逻辑相关 | 权限校验、日志记录、<br />性能监控、请求参数预处理、<br />响应结果后处理 | 字符编码设置、跨域处理、<br />安全检查(如XSS防护)、请求压缩、<br />静态资源处理 |
| 全局性任务   | 不适合全局性任务                                             | 适合全局性任务，可以拦截所有请求和响应                       |
| 框架依赖     | 必须依赖框架（如Spring），无法在非框架环境中使用             | 独立于框架，可以在任何基于servlet的项目中使用                |
| 灵活性       | 更灵活，可以根据框架特性进行定制化开发                       | 较为固定，适合处理通用任务                                   |



## 5、Spring5对Redis的使用

Spring 5对Redis的支持主要是一下几个方面：

*  1、支持基于注解的Redis缓存。

  `Spring 5` 提供了基于注解的缓存支持，可以方便的将方法返回结果缓存到Redis中，减少对数据库的访问。使用该功能需要在Spring配置文件中开启 `@EnableCaching` 注解，然后在需要缓存的方法上添加 `@Cacheable` 注解即可。

* 2、支持基于Redis的分布式锁。

  `Spring 5` 通过 `RedisTemplate` 和 `LettureConnectionFactory` 提供了基于Redis的分布式锁实现。开发人员可以通过调用`RedisTemplate`中的execute方法或使用 `@RedisLock`注解来获取分布式锁。

* 3、提供了基于Redis的响应式编程支持。

* 4、提供了Spring Session Redis。

  `Spring 5`提供了`Spring Session Redis`，用于实现分布式环境下的Session共享。`Spring Session Redis`使用`Redis`作为`Session`的存储介质，可以支持不同的`Session`存出结果（如Hash、String等），也可以使用`Spring`提供的默认结构。同时`Spring Session Redis`还提供了基于Redis的过期机制和集群支持。

* 5、提供了Redis消息监听器。

  `Spring 5`提供了`Redis`消息监听容器，可以很方便地监听`Redis`消息，实现消息的消费。开发人员可以使用`@RedisListener`注解或者手动创建`MessageListenerContainer`来实现`Redis`的监听消费。

## 6、SpringMVC特性

### 6.1、IOC

`pring IOC（Inversion of Control，控制反转）`是Spring框架的和性特点之一，他是一种软件设计思想，也是一种设计模式，其目的是降低应用程序的耦合度，提高应用程序可重用性、可维护性和可测试性。

在Spring中，IOC指的是对象的创建和依赖关系的管理不再由程序员手动完成，而是由Spring容器来完成。Spring容器会负责创建对象实例，注入对象的依赖，以及在需要的时候销毁对象实例。通过IOC机制，我们可以将对象之间的依赖关系解耦，使得应用程序的各个部分之间的耦合性更低，从而更容易进行开发和维护。

`Spring IOC`的主要特性包括：

* 1、控制反转：Spring容器负责对象的创建和依赖注入，而不是由程序员手动创建和管理对象之间的依赖关系。
* 2、依赖注入：Spring容器通过注入方式来实现对象之间的依赖关系，包括构造函数注入，setter方式注入，字段注入等。
* 3、生命周期管理：Spring容器负责对象的生命周期管理，包括对象的创建、初始化、使用和销毁。
* 4、配置管理：Spring容器通过配置文件或注解的方式来管理应用程序中的各个组件，包括对象的创建、依赖注入、属性配置等。
* 5、AOP支持：Spring容器提供了AOP（Aspect Oriented Programming，面向切面编程）的支持，使得我们可以更方便地实现横向业务逻辑的处理，如事务管理、安全控制等。

通过以上特性，Spring IOC能够实现应用程序的高度解耦，使得应用程序更易于开发和维护。

### 6.2、AOP原理

Spring AOP（面向切面编程）的原理主要基于动态代理机制，以下是其核心原理的简要介绍：

1. 代理模式：
   1. Spring AOP使用代理对象来拦截方法调用。根据目标类实现了接口，Spring会选择JDK动态代理或CGLIB代理
   2. 如果目标类实现了接口，Spring通常使用JDK动态代理；否则，使用CGLIB创建子类代理。
2. 连接点（Join Point）：
   1. 连接点是指程序执行过程中可以插入切面的地方，通常是方法调用。
3. 切入点（Pointcut）：
   1. 切入点定义了在哪些连接点应用通知（Advice）。它通过表达式匹配连接点，例如方法名、参数类型等。
4. 通知（Advice）：
   1. 通知是切面在特定连接点上执行的动作，分为前置通知（Before）、后置通知（After）、返回通知（After Returning）、异常通知（After Throwing）和环绕通知（Around）。
5. 切面（Aspect）：
   1. 切面是通知和切入点的组合，定义了何时何地执行何种操作。
6. 织入（Weaving）：
   1. 织入是将切面应用到目标对象的过程，可以在编译时、类加载时或运行时进行。Spring AOP主要在运行时进行织入。

​	

## 7、Spring事务
### 7.1、Spring事务传播行为

[Spring事务传播行为](https://mp.weixin.qq.com/s/IglQITCkmx7Lpz60QOW7HA)

Spring 事务传播行为是指在多个事务方法互相调用时，如何处理这些事务方法之间的事务关系的机制。

七种事务传播行为：

| 事务传播行为类型 | 说明                                                         |
| ---------------- | ------------------------------------------------------------ |
| `REQUIRED`       | 如果当前没有事务，就新建一个事务，如果已经存在一个事务，加入到这个事务中。 |
| `SUPPORTS`       | 支持当前事务，如果当前没有事务，就以非事务方式执行。         |
| `MANDATORY`      | 使用当前的事务，如果当前没有事务，就抛出异常。               |
| `REQUIRES_NEW`   | 新建事务，如果当前存在事务，把当前事务挂起                   |
| `NOT_SUPPORTED`  | 以非事务方式执行操作，如果当前存在事务，则把当前事务挂起     |
| `NEVER`          | 以非事务方式执行，如果当前存在事务，则抛出异常               |
| `NESTED`         | 如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与REQUIRED类似的操作 |

* 需要注意的是：事务传播行为只在多个事务方法之间相互调用时才会生效，如果只有一个事务方法，则没有事务传播的意义。

### 7.2、Spring事务原理

Spring事务传播行为的实现原理涉及到`Spring AOP`和`Spring` 事务管理器两部分内容。

首先，当一个方法别标记为`@Trancactional`注解时，Spring会使用AOP生成一个代理类，并在代理类中对该方法进行增强，在方法的前后分别添加事务处理相关代码。代理类会继承目标类的接口，并在运行时动态实现目标方法，具体实现方式可以使JDK动态代理或`CGLIB`代理。

其次，`Spring`事务管理器通过拦截器的方式将代理类的方法封装成一个事务，管理该事务的生命周期和一些细节，比如事务的隔离级别和回滚规则。当方法被调用时，`Spring`事务管理器会判断当前是否有已经开启的事务，并根据方法标记的事务传播行为和已有事务的情况来决定是否开启新事务、加入已有事务或者以非事务方式执行。在事务执行结束时，根据事务执行的结果，决定是否提交事务或者回滚事务。

总体来说，`Spring`事务传播行为的实现原理是通过`AOP`生成代理类，在代理类中对目标方法进行增强，并在代理类中调用事务管理器来管理事务的生命周期和执行过程。