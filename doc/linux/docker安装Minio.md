# Minio

## 一、简介

https://www.minio.org.cn/docs/minio/kubernetes/upstream/index.html

## 二、部署

### 2.1、拉取镜像

```shell
docker pull minio/minio
```

### 2.2、创建数据持久化文件夹

```shell
mkdir -p /mydata/minio/data
```

### 2.3、启动镜像

```shell
docker run -p 9090:9090 \
--name minio \
-d --restart=always \
 -e "MINIO_ACCESS_KEY=AccessKeyUserAdmin" \
 -e "MINIO_SECRET_KEY=SecretKeyUserAdmin" \
 -e "MINIO_ROOT_USER=MinioAdmin" \
 -e "MINIO_ROOT_PASSWORD=1024KangYong@Minio" \
 -v /mydata/minio/data:/data \
 minio/minio server \
 /data --console-address ":9090" -address ":9000"
```

>1. docker run -p 9000:9000 -p 9090:9090 :
>   1. -p 9000:9000 表示将容器内的 9000 端口映射到主机的 9000 端口，用于 Minio 对象存储服务。
>   2. -p 9090:9090 表示将容器内的 9090 端口映射到主机的 9090 端口，用于 Minio 控制台。
>2. –name minio: 将容器命名为 “minio”。
>3. -d --restart=always: 在后台运行容器，并在容器退出后自动重启容器。
>4. -e “MINIO_ACCESS_KEY=AccessKeyUserAdmin”: 设置 Minio 的访问密钥，这里设置为 “AccessKeyUserAdmin”。
>5. -e “MINIO_SECRET_KEY=SecretKeyUserAdmin”: 设置 Minio 的私有密钥，这里设置为 “SecretKeyUserAdmin”。
>6. -e “MINIO_ROOT_USER=MinioAdmin”: 设置 Minio 控制台的根用户，这里设置为 “MinioAdmin”。
>7. -e “MINIO_ROOT_PASSWORD=1024KangYong@Minio”: 设置 Minio 控制台的根用户密码，这里设置为 “1024KangYong@Minio”。
>8. -v /mydata/minio/data:/data: 将主机的 “/mydata/minio/data” 目录挂载到容器的 “/data” 目录，用于持久化存储 Minio 数据。
>9. minio/minio server /data --console-address “:9090” -address “:9000”: 使用 Minio 镜像创建容器，并将 “/data” 目录作为存储目录。" --console-address “:9090” -address “:9000"” 是 Minio 镜像特定的参数，指定了 Minio 控制台和对象存储服务的端口。

### 2.4、配置开启安全组（华为云）

### 2.5、访问Minio

ip:9090