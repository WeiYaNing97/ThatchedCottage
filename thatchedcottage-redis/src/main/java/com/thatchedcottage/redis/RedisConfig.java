package com.thatchedcottage.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 创建RedisTemplate Bean：在Spring Boot的配置类中创建一个RedisTemplate的Bean，
 * 并进行相关的配置。例如：
 *
 * 我们创建了一个RedisTemplate的Bean，并配置了key和value的序列化方式。
 * 这里使用了StringRedisSerializer序列化key，
 * 使用Jackson2JsonRedisSerializer序列化value。你也可以根据需要选择其他的序列化方式。
 */
@Configuration
public class RedisConfig {

    /**
     * 在使用RedisTemplate时需要进行一些必要的配置，否则会出现空指针异常。
     * 通过@Configuration注解，将RedisTemplate配置为Spring的Bean。通过@Bean注解，将RedisTemplate实例化并进行相关的配置。
     * 在这个示例中，使用了StringRedisSerializer作为键和值的序列化方式，你可以根据需要自定义序列化器。
     * 请确保在使用RedisTemplate之前，将该配置类添加到你的Spring配置中。这样就可以避免空指针异常并正确使用RedisTemplate了。
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        // 设置key的序列化器
        StringRedisSerializer stringSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringSerializer);
        template.setHashKeySerializer(stringSerializer);
        // 设置value的序列化器
        Jackson2JsonRedisSerializer<Object> jsonSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jsonSerializer.setObjectMapper(objectMapper);
        template.setValueSerializer(jsonSerializer);
        template.setHashValueSerializer(jsonSerializer);

        template.afterPropertiesSet();
        return template;
    }

    /*
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }
    */
}
