# study-01

## 01、什么是Dubbo？ 它有哪些核心功能？

Dubbo是一款高性能、轻量级的开源RPC框架。由10层模式构成，整个分层依赖由上而下。

* business
* rpc
* remoting

## 02、Dubbo的负载均衡策略

* 加权随机
* 最小活跃数
* 一致性hash
* 加权轮询
* 最短响应时间权重
