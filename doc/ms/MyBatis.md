[TOC]

# MyBatis

* MyBatis
* MyBatis-Plus

## 1、MyBatis中 $ 和 # 区别

MyBatis提供到的#号占位符和$号占位符，都是实现动态SQL的一种方式，通过这两种方式把参数传递到xml之后，在执行操作之前，MyBatis会对这两种占位符进行动态解析。

#号占位符，等同于jdbc里面的？号占位符。

他相当于向PreparedStatement中的预处理语句中设置参数，而PreparedStatement中的SQL语句是预编译的，SQL语句中使用了占位符，规定了SQL语句的结构。并且在设置参数的时候，如果有特殊字符，会自动进行转义。所以#号占位符可以防止SQL注入。

而使用$的方式传参，相当于直接把参数拼接到了原始的SQL里面，MyBatis不会对他进行特殊处理。

## 2、MyBatis一级缓存、二级缓存

## 3、PageHelper分页原理