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

## 3、Spring循环依赖

## 4、拦截器和过滤器的区别

## 5、Spring5对Redis的使用

## 6、SpringMVC特性

### 6.1、IOC

### 6.2、AOP原理

## 7、Spring事务
### 7。1、Spring事务传播行为
### 7、2、Spring事务原理
