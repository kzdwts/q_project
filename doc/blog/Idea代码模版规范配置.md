# Idea代码模版规范配置

## 1、Copyright 配置 

Settings --> Copyright （没有此选项可以去plugins下去下载）

![image-20250610135502803](https://gitee.com/kzdwts/typora-picgo/raw/master/typora/202506101355909.png)



Copyright Text 替换成：

Copyright(c) $today.year 企业名字 Co., Ltd.

All right reserved.

![image-20250610135608698](https://gitee.com/kzdwts/typora-picgo/raw/master/typora/202506101356732.png)



![image-20250610135625354](https://gitee.com/kzdwts/typora-picgo/raw/master/typora/202506101356392.png)



## 2、配置Class 文件描述

### 2.1、File Header 配置

Settings -->File and Code Templates -->includes -->File Header

```java
/**
 *
 * 
 * TODO description.
 * @author KangYong
 * @date ${DATE}
 * @since 1.0.0
 */
```

![image-20250610140003703](https://gitee.com/kzdwts/typora-picgo/raw/master/typora/202506101400743.png)



### 2.2、Live Templates 配置

Settings --> Live Templates -->+ -->Template Group -->users（组名可以任意起） ->Ok

![image-20250610140324123](https://gitee.com/kzdwts/typora-picgo/raw/master/typora/202506101403157.png)

![image-20250610140335456](https://gitee.com/kzdwts/typora-picgo/raw/master/typora/202506101403491.png)



选中users --> + --> Live Template

![image-20250610140355770](https://gitee.com/kzdwts/typora-picgo/raw/master/typora/202506101403800.png)

选择语言时，选择java即可，模板里的变量都是 $变量$来标识，可以再Edit Variables 去制定

![image-20250610140420700](https://gitee.com/kzdwts/typora-picgo/raw/master/typora/202506101404739.png)

##### ***Skip if defined 建议全部勾选***

模板配置：

```java
**
 * 功能: .
 * @author KangYong
 * @date $date$
 *$params$
 *$returns$
 */
```



其中$params$ 、$returns$ 变量是由groovy script 脚本处理

params :

```groovy
groovyScript("def result=''; def params=\"${_1}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split(',').toList(); def paramsType=\"${_2}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split(',').toList(); if (''.equals(params.get(0))) {return '';}; for(i = 0; i < params.size(); i++) {result+= (i > 0 ? ' * @param ':' @param ') + params[i] +((i < params.size() - 1) ? ' {@link '+paramsType[i]+'}\\n' : ' {@link ' + paramsType[i]) + '}'}; return result", methodParameters(),methodParameterTypes())
```

returns:

```groovy
groovyScript("def returnV = \"${_1}\".toString();return 'void'.equals(returnV) ? '':' @return {@link ' + returnV + '}';",methodReturnType())
```



