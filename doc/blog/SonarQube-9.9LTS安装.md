[TOC]

# SonarQube-9.9LTS 安装



## 一、准备工作

当前时间`2023年5月8日`，最新的`SonarQube`版本是10.0

SonarQube-9.9LTS 是长期支持版本，[为什么选择9.9版本](https://www.sonarsource.com/products/sonarqube/downloads/lts/)

### 1.1、版本选型


| 组件       | 版本                                                         | 描述                                             |
| ---------- | ------------------------------------------------------------ | ------------------------------------------------ |
| jdk        | JDK 17                                                       | Java运行环境，SonarQube-9.9LTS 需要 jdk17 支持   |
| PostgreSQL | 14.5                                                         | 数据库                                           |
| SonarQube  | [社区版 9.9-LTS](https://www.sonarsource.com/products/sonarqube/downloads/) | SonarQube 9.9LTS，2023 年 2 月发布，是长期支持版 |

### 1.2、硬件要求

* 1. SonarQube 服务器的小规模（个人或小团队）实例需要至少 2GB 的 RAM 才能高效运行，并需要 1GB 的可用 RAM 供操作系统使用。如果您要为大型团队或企业安装实例，请考虑以下其他建议。
* 2. 您需要的磁盘空间量将取决于您使用 SonarQube 分析的代码量。
* 3. SonarQube 必须安装在具有出色读写性能的硬盘上。最重要的是，“数据”文件夹包含 Elasticsearch 索引，当服务器启动并运行时，大量的 I/O 将在这些索引上完成。因此，读写硬盘性能将对整体 SonarQube 服务器性能产生很大影响。

## 二、安装

当前操作系统`CentOS7`

### 2.3、安装

#### 2.3.1、解压SonarQube&汉化

下载 [社区版 9.9.1.69595.zip](https://www.sonarsource.com/products/sonarqube/downloads/) 并上传文件到`/usr/local/wts/`目录下

* 解压

```shell
cd /usr/local/wts
# 解压
unzip sonarqube-9.9.1.69595.zip
# 更改文件夹名
mv sonarqube-9.9.1.69595 sonarqube-9.9
```

* 汉化 安装中文语言包

  登录后, 打开 `Administration → Marketplace`, 搜索 `chinese pack`, 点击 `install`

  ![sonar-l10n-zh-plugin-1.28.jar](images\1022-sonar-plugin-chinese-step1.png)

  ![](images\1023-sonar-plugin-chinese-step2.png)

#### 2.3.2、创建sonarqube数据库

`PostgreSQL`数据库安装参考

* [PostgresSql在linux下源码安装](https://blog.csdn.net/u010080562/article/details/127349394)

新增用户并创建数据库：

```sql
# 创建数据库用户
create user admin password '123456';

# 创建数据库
create database sonarqube;
alter database sonarqube owner to admin;

# 给数据库授权
grant all privileges on database sonarqube to admin;
```

#### 2.3.3、修改数据库连接

在`SonarQube`的配置文件`/usr/local/wts/sonarqube-9.9/conf/sonar.properties`中添加如下配置：

```properties
# 数据库连接信息
sonar.jdbc.url=jdbc:postgresql://192.168.10.134:5432/sonarqube?currentSchema=public
sonar.jdbc.username=admin
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
chown -R sonar:sonar /usr/local/wts/sonarqube-9.9/
```

#### 2.3.6、相关报错解决

直接启动sonar，可能内部组件elasticsearch会报错：

需要修改配置：

①`[1]: max file descriptors [4096] for elasticsearch process is too low, increase to at least [65535]`

每个进程最大同时打开文件数太小，可通过下面2个命令查看当前数量

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

②`[2]: max virtual memory areas vm.max_map_count [65530] is too low, increase to at least [262144]`

最大线程个数太低，可通过命令查看

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

最大虚拟内存。修改`/etc/sysctl.conf`文件，增加配置

```properties
vm.max_map_count=262144
```

执行命令`sysctl -p`生效

④`Exception in thread "main" java.nio.file.AccessDeniedException: /usr/local/wts/sonarqube-9.9/elasticsearch/config/es/elasticsearch.yml`

启动elasticsearch的用户没有该文件夹的权限，执行命令：

```bash
chown -R sonar:sonar /usr/local/wts/sonarqube-9.9/
```



#### 2.3.7、登录启动用户，启动程序

```shell
su - sonar
cd /usr/local/wts/sonarqube-9.9/bin/linux-x86-64
sh sonar.sh start
```

#### 2.3.8、登录

浏览器打开 `http://ip:9000`

用户名/密码：`admin/admin`



***至此 SonarQube服务安装完成***