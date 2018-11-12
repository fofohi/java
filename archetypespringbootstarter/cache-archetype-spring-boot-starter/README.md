#author
 * 孙朱焕
 - 邮箱:sunzhuhuan@jiangduoduo.com

##Redis-stater 综述
*使用方式同原来的方式,不支持混合的方式,即 不能同时存在单实例和集群,如果有这个需求,请自己应用内自己再手动实例化一个需要的redis
*配置方式，apollo 内配置 redis 地址
##
  #基本配置
 spring.redis.timeout = 1000  
 spring.redis.lettuce.pool.min-idle = 2  
 spring.redis.lettuce.pool.max-idle = 8  
 spring.redis.lettuce.pool.max-wait = -1ms  
 spring.redis.lettuce.pool.max-active = 16  
  #集群
 spring.redis.cluster.nodes = 172.16.250.194:6389,172.16.250.5:6386,172.16.250.5:6387,172.16.251.94:6385,172.16.251.94:6386,172.16.250.194:6390  
 spring.redis.cluster.max-redirects = 3  
  #单实例
 spring.redis.database = 0  
 spring.redis.host = 172.16.250.5  
 spring.redis.port = 6390  
 spring.redis.password = jdd.com  