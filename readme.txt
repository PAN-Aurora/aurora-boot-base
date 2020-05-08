(1) 目录结构说明
        aurora-base:
           父版本 主要配置子模块需要的mmaven 及子模块相关信息

        aurora-common：
           公共模块主要负责封装相关公共的实体 工具类 等相关公共使用的类

        aurora-config：
            公共配置模块 主要所有公共相关的配置 拦截器 自定义主键 aop config配置

        aurora-model：
            实体模块：所有实体对象所在模块

        aurora-service：
            业务接口模块 业务接口 和实现类 及dao接口,mapper.xml

        aurora-web:
             对外访问的视图层，所有的controller，主要与页面交互

(2)依赖关系：

 最基础的是模块：model,common,web 都直接依赖或者间接依赖
   aurora-common，aurora-config
 依赖关系：
  aurora-base -> aurora-model -> aurora-service -> aurora-web
              


(3) 数据库文件脚本：
   根目录下：mysql-aurora.sql 文件


