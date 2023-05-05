[TOC]

# SonarQube 使用手册



## 一、简介

### 1.1、概述

[SonarQube](https://docs.sonarqube.org/latest/) 是一种自动代码审查工具，用于检测代码中的错误、漏洞和代码异味。

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

### 2.1、版本选型

| 组件      | 版本                                                         | 描述                                        |
| --------- | ------------------------------------------------------------ | ------------------------------------------- |
| jdk       | 1.8.0                                                        | Java运行环境                                |
| MySQL     | 5.7                                                          | 数据库                                      |
| SonarQube | [社区版 7.8]([SonarSource Downloads-CDN](https://binaries.sonarsource.com/?prefix=Distribution/sonarqube/)) | SonarQube 7.9开始需要Java 11且不支持mysql了 |

### 2.2、硬件要求

* 1. SonarQube 服务器的小规模（个人或小团队）实例需要至少 2GB 的 RAM 才能高效运行，并需要 1GB 的可用 RAM 供操作系统使用。如果您要为大型团队或企业安装实例，请考虑以下其他建议。
* 2. 您需要的磁盘空间量将取决于您使用 SonarQube 分析的代码量。
* 3. SonarQube 必须安装在具有出色读写性能的硬盘上。最重要的是，“数据”文件夹包含 Elasticsearch 索引，当服务器启动并运行时，大量的 I/O 将在这些索引上完成。因此，读写硬盘性能将对整体 SonarQube 服务器性能产生很大影响。
* 4. SonarQube 在服务器端不支持 32 位系统。然而，SonarQube 在扫描器端支持 32 位系统。

### 2.3、安装

#### 2.3.1、解压SonarQube&汉化

* 解压

```shell
# 解压
unzip sonarqube-7.8.zip
```

* 汉化 安装中文语言包

  ~~登录后, 打开 `Administration → Marketplace`, 搜索 `chinese pack`, 点击 `install~~

  由于低版本`SonarQube`自带的插件商店没有对应的汉化版本，这里我们下载汉化插件 [sonar-l10n-zh-plugin-1.28.jar](https://github.com/xuhuisheng/sonar-l10n-zh/releases)

  ![sonar-l10n-zh-plugin-1.28.jar](images\1004-sonar-zh-plugin.png)

  下载完成之后，我们将这个jar包放入`SonarQube`的安装目录下的`extensions/plugins`文件夹中即可。

#### 2.3.2、创建SonarQube数据库

由于`SonarQube`默认使用的内嵌数据库`H2`，这种不适应于生产环境。所以我们替换成`mysql`数据库。

首先创建一个名为`sonar`的数据库。

```sql
CREATE DATABASE `sonar` CHARACTER SET 'utf8mb4';
```

#### 2.3.3、修改数据库连接

在`SonarQube`的配置文件`conf/sonar.properties`中添加如下配置：

```properties
# 数据库连接信息
sonar.jdbc.url=jdbc:mysql://localhost:3306/sonar?useUnicode=true&characterEncoding=utf8&rewriteBatchedStatements=true&useConfigs=maxPerformance&useSSL=false
sonar.jdbc.username=root
sonar.jdbc.password=123456
sonar.sorceEncoding=UTF-8
# SonarQube的web页面登录信息
sonar.login=admin
sonar.password=admin
```

#### 2.3.4、创建SonarQube启动用户

SonarQube内置了elasticsearch，elasticsearch不允许使用root用户启动

```shell
# 创建用户
useradd sonar
passwd sonar
```

#### 2.3.5、赋予启动用户执行权限

```shell
chown -R sonar:sonar /usr/local/data/soft/sonarqube-7.8/
```

#### 2.3.6、配置elasticsearch相关参数

直接启动sonar，可能内部组件elasticsearch会报错：

```verilog
[1]: max file descriptors [4096] for elasticsearch process is too low, increase to at least [65535]
[2]: max virtual memory areas vm.max_map_count [65530] is too low, increase to at least [262144]
```

修改配置：

①每个进程最大同时打开文件数太小，可通过下面2个命令查看当前数量

```bash
ulimit -Hn
ulimit -Sn
```

![](images\1001-sonar-es-cfg-hnsn.png)

修改`/etc/security/limits.conf`文件，增加配置，用户退出后重新登录生效

```properties
*	soft    nofile  65536
*	hard    nofile  65536
```

②最大线程个数太低，可通过命令查看

```bash
ulimit -Hu
ulimit -Su
```

![](images\1007-sonar-es-cfg-husu.png)

修改配置文件/etc/security/limits.conf（和问题1是一个文件），增加配置

```properties
*	soft	nproc	4096
*	hard	nproc	4096

```

修改后的文件：

![](images\1008-sonar-es-cfg1.png)

③max virtual memory areas vm.max_map_count [65530] is too low, increase to at least [262144]

修改`/etc/sysctl.conf`文件，增加配置

```properties
vm.max_map_count=262144
```

执行命令`sysctl -p`生效

④`Exception in thread "main" java.nio.file.AccessDeniedException: /usr/local/data/soft/sonarqube-7.8/elasticsearch/config/es/elasticsearch.yml`

启动elasticsearch的用户没有该文件夹的权限，执行命令：

```bash
chown -R sonar:sonar /usr/local/data/soft/sonarqube-7.8/
```



#### 2.3.7、登录启动用户，启动程序

```shell
su - sonar
cd /usr/local/data/soft/sonarqube-7.8/bin/linux-x86-64
sh sonar.sh start
```

#### 2.3.8、登录

浏览器打开 `http://ip:9000`

用户名/密码：`admin/admin`



***至此 SonarQube服务安装完成***

#### 2.3.9、常用命令

```shell
# 启动
sh sonar.sh start
# 关闭
sh sonar.sh stop

# service sonar start
# service sonar stop
# service sonar restart

# chkconfig sonar on
# chkconfig sonar off
```



## 三、创建项目

这里简述创建项目的过程

![](images\1019-sonar-create-project-step1.png)

![](images\1020-sonar-create-project-step2.png)

![](images\1021-sonar-create-project-step3.png)



## 四、使用

下面将通过四种方式来使用`SonarQube`的代码扫描功能：

* 开发人员自查(选其一即可)
  * ①Idea安装SonarLint插件
  * ②Maven方式执行代码检测
  * ③SonarScanner方式执行代码检测
* 团队进行 Code Review
  * ④集成Jenkins执行代码检测

### 4.1、Idea安装SonarLint插件

`File` → `Settings` → `Plugins` → `Marketplace` → 搜索`SonarLint`

![](images\1002-sonar-idea-sonarlint.png)

### 4.2、集成maven执行代码扫描

创建完项目后，我们选择maven方式构建，即可看到SonarQube给我们提供的maven扫描命令

```bash
mvn sonar:sonar \
-Dsonar.projectKey=项目名 \
-Dsonar.host.url=http://ip:9000 \
-Dsonar.login=令牌
```

#### 4.2.1、使用方式

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

执行完毕后在SonarQube页面即可看到扫描结果：

![](images\1005-sonar-bad-taste.png)

### 4.3、通过SonarScanner执行代码扫描

SonarQube提供了SonarScanner组件来帮助我们执行扫描，首先下载 [4.6版本](https://docs.sonarqube.org/latest/analysis/scan/sonarscanner/)

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

### 4.4、集成Jenkins执行代码扫描

#### 4.4.1、Jenkins安装 SonarQube Scanner插件

`系统管理 > 插件管理`，搜索`SonarQube Scanner`插件并安装

![](images\1006-sonar-sonarqube-scanner.png)

#### 4.4.2、Jenkins配置SonarQube

* ①开启Sonar Qube权限验证

  ![](images\1010-sonar-cfg-auth-true.png)

* ②获取SonarQube的令牌

  在SonarQube web页面： `我的账号` → `安全`

  ![](images\1009-sonar-web-gen-authtoken.png)

* ③配置Jenkins的SonarQube信息

  jenkins web页面：`系统管理` → `系统配置` → `SonarQube servers`

  ![](images\1011-sonar-jenkins-cfg-step1.png)

  ![](images\1013-sonar-jenkins-cfg-step2.png)

  ![](images\1012-sonar-jenkins-cfg-step3.png)

#### 4.4.3、配置Sonar-scanner

* ①下载 [Sonar Scanner 4.6版本](https://docs.sonarqube.org/latest/analysis/scan/sonarscanner/) 放到服务器并解压

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

### 4.5、查看扫描结果

从jenkins点击链接跳转，或者直接访问SonarQube页面

![](images\1016-sonar-jenkins-result1.png)

![](images\1017-sonar-jenkins-result2.png)

![](images\1018-sonar-jenkins-result3.png)