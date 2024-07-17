[TOC]

# MyBatis

* MyBatis
* MyBatis-Plus

## 1、MyBatis中 $ 和 # 区别

MyBatis提供到的#号占位符和$号占位符，都是实现动态SQL的一种方式，通过这两种方式把参数传递到xml之后，在执行操作之前，MyBatis会对这两种占位符进行动态解析。

`#` 号占位符，等同于jdbc里面的`？`号占位符。

他相当于向PreparedStatement中的预处理语句中设置参数，而PreparedStatement中的SQL语句是预编译的，SQL语句中使用了占位符，规定了SQL语句的结构。并且在设置参数的时候，如果有特殊字符，会自动进行转义。所以#号占位符可以防止SQL注入。

而使用$的方式传参，相当于直接把参数拼接到了原始的SQL里面，MyBatis不会对他进行特殊处理。

## 2、MyBatis一级缓存、二级缓存

`MyBatis`提供了两级缓存来加速查询速度，分别为一级缓存和二级缓存。

* 一级缓存

  MyBatis的一级缓存是sqlSession级别的缓存，当我们向数据库发起一个查询请求时，MyBatis会先从一级缓存中查找，如果缓存中有，则直接返回缓存中的数据；如果没有，则会去数据库中查询，并将查询结果存放到缓存中。当sqlSession对象被关闭时，一级缓存也会被清空。

* 二级缓存

  MyBatis的二级缓存是Mapper级别的缓存，可以被多个SqlSession对象共享。当多个SqlSession对象对同一个Mapper执行相同的查询时，MyBatis会先从二级缓存中查找，如果缓存中有，则直接返回缓存中的数据；如果没有，则会去数据库中查询，并将查询结果放到缓存中。二级缓存是需要手动开启的，在Mapper.xml文件中添加`<cache />`节点来开启二级缓存。

  * `cache`标签:`<cache flushInterval="300000" size="512" />`
    * `flushInterval` 缓存刷新间隔
    * `size` 缓存存放多少个元素
    * `readOnly` 是否只读；**true 只读**
    * `type` 指定自定义缓存的全类名（实现Cache接口）
    * `blocking` 

* 三级缓存

  MyBatis不存在三级缓存，二级已经可以满足大部分的需求。

  如果需要更高级别的缓存功能，可以考虑Redis

当我们修改了数据中的数据时，MyBatis会自动清空该Mapper的一级缓存和二级缓存，以保证缓存中的数据与数据库中的数据一致。同事由于二级缓存是可共享的，所以在多个SqlSession中共享一个Mapper时，需要特别注意缓存带来的数据一致性问题。

## 3、PageHelper分页原理

PageHelper是MyBatis的一个分页插件，可以方便的对查询结果进行分页处理。其原理主要是通过MyBatis的拦截器机制，在SQL执行前和执行后动态修改SQL语句，实现分页功能。

具体来说，PageHelper主要通过以下几个步骤实现分页：

* 1、拦截SQL语句：PageHelper会拦截SQL语句，获取查询参数中的分页信息，如当前页码、每页数据条数等。
* 2、修改SQL语句：根据获取到的分页信息，PageHelper会动态修改SQL语句，添加分页限制条件，如`limit`语句。
* 3、执行SQL语句：修改后的SQL语句会被执行，返回分页后的查询结果。
* 4、封装分页结果：PageHelper会将分页后的查询结果封装成Page对象，包括分页信息和查询结果列表。

PageHelper支持多种数据库的分页方式，如MySQL、Oracle、SQLServer等，通过配置不同的分页插件，可以实现不同数据库的分页功能。