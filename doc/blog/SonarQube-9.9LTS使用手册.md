[TOC]

# SonarQube-9.9LTS 使用手册



## 一、简介

### 1.1、概述

[SonarQube](https://docs.sonarqube.org/9.9/) 是一种自动代码审查工具，用于检测代码中的错误、漏洞和代码异味。

支持包括` java, C#, C/C++, PL/SQL, Cobol, JavaScrip, Groovy` 等等二十几种编程语言的代码质量管理与检测。

### 1.2、实例组件

一个 SonarQube 实例包含三个组件：

![](images\1003-sonar-instance.png)

1. SonarQube 服务器运行以下进程：
   - 服务于 SonarQube 用户界面的 Web 服务器。
   - 基于 Elasticsearch 的搜索服务器。
   - 负责处理代码分析报告并将其保存在 SonarQube 数据库中的计算引擎。
2. 数据库存储以下内容：
   - 代码扫描期间生成的代码质量和安全性指标和问题。
   - SonarQube 实例配置。
3. 在您的构建或持续集成服务器上运行的一台或多台扫描仪，用于分析项目。

## 二、安装

[SonarQube-9.9LTS安装](SonarQube-9.9LTS安装.md)



## 三、使用

### 3.1、常用命令

```shell
# 启动
sh sonar.sh start
# 关闭
sh sonar.sh stop
# 重启
sh sonar.sh restart
```



### 3.2、代码扫描

下面将通过四种方式来使用`SonarQube`的代码扫描功能：

* 开发人员自查(选其一即可)
  * ①Idea安装SonarLint插件
  * ②Maven方式执行代码检测
  * ③SonarScanner方式执行代码检测
* 团队进行 Code Review
  * ④集成Jenkins执行代码检测

#### 3.2.1、Idea安装SonarLint插件

`File` → `Settings` → `Plugins` → `Marketplace` → 搜索`SonarLint`

![](images\1002-sonar-idea-sonarlint.png)

#### 3.2.2、集成maven执行代码扫描

在`SonarQube Web`页面创建项目：

![](images\1019-sonar-create-project-step1.png)

![](images\1020-sonar-create-project-step2.png)

![](images\1021-sonar-create-project-step3.png)

创建完项目后，我们选择maven方式构建，即可看到SonarQube给我们提供的maven扫描命令

```bash
mvn sonar:sonar \
-Dsonar.projectKey=项目名 \
-Dsonar.host.url=http://ip:9000 \
-Dsonar.login=令牌
```

##### 3.2.2.1、使用方式

①进入到要扫描的代码目录，执行上面的maven命令即可。

②上面的命令中有些是固定的信息，如果每次执行扫描都需要输入则显的很麻烦，这里我们可以将某些信息配置到maven的`setting.xml`中

```xml
<profile>
  <id>sonar</id>
  <activation>
	<activeByDefault>true</activeByDefault>
  </activation>
  <properties>
	<sonar.host.url>http://ip:9000</sonar.host.url>
	<sonar.login>admin</sonar.login>
    <sonar.password>密码</sonar.password>
  </properties>
</profile>
```

在代码位置执行命令：

```shell
mvn sonar:sonar
```

执行完毕后在`SonarQube`页面即可看到扫描结果：

![](images\1005-sonar-bad-taste.png)

#### 3.2.3、通过SonarScanner执行代码扫描

SonarQube提供了SonarScanner组件来帮助我们执行扫描，首先下载 [Sonar Scanner 4.8版本](https://docs.sonarqube.org/9.9/analyzing-source-code/scanners/sonarscanner/)

下载之后是个压缩包，解压即可，为了方便使用，我们可以将解压后的目录下的bin目录加入到环境变量中，这样可以直接使用`sonar-scanner`命令了

打开SonarScanner的配置文件`conf/sonar-scanner.properties`，做如下修改：

```properties
# Default SonarQube Server
sonar.host.url=http://ip:9000
# Default source code encoding 
sonar.sourceEncoding=UTF-8
# 令牌
sonar.login=令牌
```

进入到待扫描的项目目录下，新建`sonar-project.properties`文件，内容如下：

```properties
sonar.projectKey=test
sonar.projectName=test
#sonar.projectVersion=1.0
#sonar.sources=./src
sonar.sourceEncoding=UTF-8
#sonar.language=java
sonar.java.binaries=.
```

然后在命令行执行`sonar-scanner`即可。

#### 3.2.4、集成Jenkins执行代码扫描

##### 3.2.4.1、Jenkins安装 SonarQube Scanner插件

`系统管理 > 插件管理`，搜索`SonarQube Scanner`插件并安装

![](images\1006-sonar-sonarqube-scanner.png)

##### 3.2.4.2、Jenkins配置SonarQube

* ①开启Sonar Qube权限验证

  ![](images\1010-sonar-cfg-auth-true.png)

* ②获取SonarQube的令牌

  在SonarQube web页面： `我的账号` → `安全`

  ![](images\1009-sonar-web-gen-authtoken-v2.png)

* ③配置Jenkins的SonarQube信息

  jenkins web页面：`系统管理` → `系统配置` → `SonarQube servers`

  ![](images\1011-sonar-jenkins-cfg-step1.png)

  ![](images\1013-sonar-jenkins-cfg-step2.png)

  ![](images\1012-sonar-jenkins-cfg-step3.png)

##### 3.2.4.3、配置Sonar-scanner

* ①下载 [Sonar Scanner 4.8版本](https://docs.sonarqube.org/9.9/analyzing-source-code/scanners/sonarscanner/) 放到服务器并解压

  这一步极其重要，jenkins部署项目时会调用其进行代码扫描

* ②将Sonar-scanner添加到Jenkins数据卷中并配置全局配置

  jenkins web页面：`系统管理` → `全局工具配置` → `SonarQube Scanner`

  ![](images\1014-sonar-jenkins-sonarscanner-cfg.png)

* ③新建任务，并配置任务的Sonar-scanner

  `构建`

  ```properties
  sonar.projectName=${JOB_NAME}
  sonar.projectKey=${JOB_NAME}
  sonar.language=java
  sources=./
  sonar.java.binaries=target/
  ```

  ![](images\1015-sonar-jenkins-build-cfg.png)

### 3.3、查看扫描结果

从jenkins点击链接跳转，或者直接访问SonarQube页面

![](images\1016-sonar-jenkins-result1.png)

![](images\1017-sonar-jenkins-result2-v2.png)

![](images\1018-sonar-jenkins-result3-v2.png)