1.修改数据库配置端口
2.数据库只是读写分离，但是数据库需要配置复制,使用双数据源，连接池默认Hikari和druid
3.项目采用SpringBoot+mybatis,数据库使用mysql,缓存数据库使用redis，redis集群哨兵都有配置，打开即可使用
4.已经统一配置去全局异常处理，添加了异常404，500页面 
5.已配置swagger文档，地址http://localhost:8099/swagger-ui.html，json文档：http://localhost:8099/rest/doc