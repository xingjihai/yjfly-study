package com.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redis.entity.User;
import org.msgpack.jackson.dataformat.MessagePackFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Value("${redis.host}")
    private String hostName;


    @Value("${redis.port}")
    private int port;
    /**
     * 关于JedisConnectionFactory的配置：
     *  1. 主机与端口号:在配置体系中由RedisStandaloneConfiguration负责设置,在JedisConnectionFactory中有个standaloneConfig字段默认设置了"localhost:6379"的地址
     *  2. 用户名与密码:在配置体系中由RedisSentinelConfiguration负责配置,但redis默认可以无需用户登录,所以要配置用户名与密码需要调用JedisConnectionFactory(RedisSentinelConfiguration sentinelConfig)的构造方法
     *  3. 其他配置:redis的其他配置选项由三层架构构成,分别为:BaseObjectPoolConfig->GenericObjectPoolConfig->JedisPoolConfig
     *      实际上在JedisPoolConfig已经将所有配置设置完毕,如果用户需要自定义设置,可以创建JedisPoolConfig实例,也可以创建GenericObjectPoolConfig实例,区别在于JedisPoolConfig可以比GenericObjectPoolConfig多配置四个参数
     *      在用户自定JedisPoolConfig之后可以调用new JedisConnectionFactory(JedisPoolConfig)获取工厂实例.
     *      而实际上,JedisConnectionFactory有一个内部类MutableJedisClientConfiguration,MutableJedisClientConfiguration中默认创建有JedisPoolConfig的实例
     *          如果用户未自定义JedisPoolConfig则JedisConnectionFactory直接使用MutableJedisClientConfiguration中的配置,
     *          如果用户自定义了JedisPoolConfig,则MutableJedisClientConfiguration会调用setPoolConfig(GenericObjectPoolConfig poolConfig)方法进行处理,可以注意到,这里的poolconfig实际上是一个GenericObjectPoolConfig
     *  4. 总结:
     *      要是不进行配置,直接调用JedisConnectionFactory的无参构造即可;
     *      如果要设置密码,实例化RedisSentinelConfiguration进行配置;
     *      如果要设置主机,实例化RedisStandaloneConfiguration进行配置
     *      如果要设置其他项目,实例化JedisPoolConfig进行配置
     * @return
     */
    @Bean(name="jedisConnectionFactory")
    public JedisConnectionFactory getFactory(){
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(hostName);
        jedisConnectionFactory.setPort(port);
        return jedisConnectionFactory;
    }


    /**
     * RedisTemplate本身不提供带有JedisConnectionFactory的有参构造方法,甚至不提供setJedisConnectionFactory()的方法,setJedisConnectionFactory()方法为其父类RedisAccessor提供的
     * connectionFactory作为RedisAccessor的字段,被RedisTemplate所继承,可以在xml中进行配置
     * @return
     */
//    @Bean(name="redisTemplate")
//    public RedisTemplate<String, User>  getTemplate(){
//        RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(getFactory());
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//
////        ObjectMapper objectMapper = new ObjectMapper(new MessagePackFactory());
//        Jackson2JsonRedisSerializer<User> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<User>(User.class);
////        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
////        RedisSerializer redisSerializer = jackson2JsonRedisSerializer;
////        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
////        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
//        return redisTemplate;
//    }

    @Bean(name="redisTemplate")
    public RedisTemplate<String, Object>  getTemplate(){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(getFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        RedisSerializer redisSerializer = jackson2JsonRedisSerializer;
        redisTemplate.setValueSerializer(redisSerializer);

        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(redisSerializer);
        return redisTemplate;
    }




}
