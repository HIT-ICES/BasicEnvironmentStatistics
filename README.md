该模板集成了 gitlab cli 配置，具体见 `.gitlab-cli` 配置文件。主要包含以下功能：

1. 自动测试
2. 代码质量检测（192.168.1.102:9000）
3. 自动构建
4. 镜像打包，并推送到 192.168.1.102:5000

> 每次提交后都会触发上述流程。在gitlab项目页面左侧的 CI/CD 即可查看。请务必确保 CI 通过。通过之后即可直接从 192.168.1.102:5000 上拉取镜像进行测试。

具体详情请见配置文件。

### 使用时，fork 后**务必确保修改** `pom.xml` 以及 `applications.yaml` 中的项目名称

# Basic Environment Statistics

## 一些说明

- 模式：异质环境数据的类型定义。一个模式定义包含id、友好名和字段列表定义
- 字段：异质环境数据类型的某个字段。字段定义包含类型（text,number,enum,bool）、名称和值约束
- 值约束是对字段取值范围的约束
- 每条异质化的数据，按照各字段依次序列化为字符串数组储存。每条数据具有自己的Id。
  
## API

|路径|输入|输出|功能|方法|
|:---:|:---:|:---:|:---:|:---:|
|/statistic/schema/get|模式ID|模式|获取指定id的模式|POST|
|/statistic/schema/add|模式|模式ID|创建指定模式|POST|
|/statistic/schema/remove|模式ID|被删除的模式|删除指定模式|POST|
|/statistic/data/get|数据ID|数据|获取特定Id的数据|POST|
|/statistic/data/select|模式ID，时间范围|一组数据|获取所有符合指定要求的数据|POST|
|/statistic/data/insert|模式ID，一组数据|成功插入的数据的Id|插入指定的一组数据|POST|
|/statistic/data/remove|一组数据ID|成功删除的条数|删除指定的数据|POST|
