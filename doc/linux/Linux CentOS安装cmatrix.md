# Linux CentOS安装cmatrix[（骇客屏保）](https://www.cnblogs.com/steven7/p/14113389.html)

## 1、安装`ncureses`支持包

```shell
yum install ncurses*  # 安装相关ncurses支持包
```

## 2、下载cmatrix骇客屏保源码包，由于是https网站资源需要加 --no-check-certificate指令参数

```shell
wget --no-check-certificate https://jaist.dl.sourceforge.net/project/cmatrix/cmatrix/1.2a/cmatrix-1.2a.tar.gz
```

## 3、解压缩源码包

```shell
tar -zxvf cmatrix-1.2a.tar.gz
```

## 4、进入源码包目录

```shell
cd cmatrix-1.2a/
```

## 5、释放编译文件

```shell
./configure --prefix=/opt/cmatrix/
```

## 6、编译且安装

```shell
make && make install
```

## 7、进入安装屏保软件的目录，执行屏保命令

```shell
cd /opt/cmatrix/
./bin/cmatrix
```



* cmatrix使用说明

```
cmatrix [-abBflohnsVx] [-C color]

选项
-a :异步滚动（默认）
-b :随机粗体
-B :全部粗体
-f :force the linux $TERM type to be on
   求大神解释
-l :Linux mode (sets "matrix.fnt" font in console)
   求大神解释
-o :使用旧风格滚动（不好看）
-h :获得帮助信息
-n :不使用粗体（默认）
-s :"Screensaver" mode,exits on first keystroke
   求大神解释
-x :X window 模式，好像就是显示的符号不一样
-V :显示版本信息
-u :刷新频率，0-9，也就是滚动的快慢
-C :显示的颜色，支持green(默认),red,blue,white,yellow,cyan,
       magenta and black
```

* 在运行的状态下，直接按q，即可退出程序