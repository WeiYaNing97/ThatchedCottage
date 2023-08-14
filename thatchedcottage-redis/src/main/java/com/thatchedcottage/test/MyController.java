package com.thatchedcottage.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/MyController")
public class MyController {

    /*在需要使用Redis的地方注入RedisTemplate对象，并使用其提供的方法进行操作。*/
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 字符串操作
     */
    @GetMapping("/set")
    public String setValue() {
        redisTemplate.opsForValue().set("myKey", "myValue");
        return "Value set successfully";
    }
    @GetMapping("/get")
    public String getValue() {
        String value = (String) redisTemplate.opsForValue().get("myKey");
        return "Value retrieved: " + value;
    }
    @DeleteMapping("/delete")
    public Boolean deleteValue() {
        Boolean myKey = redisTemplate.delete("myKey");
        System.out.println("操作是否成功："+myKey);
        return myKey;
    }

    /**
     * 哈希操作：
     * 设置哈希字段的值：redisTemplate.opsForHash().put(hashKey, field, value)
     * 获取哈希字段的值：redisTemplate.opsForHash().get(hashKey, field)
     * 获取哈希的所有字段和值：redisTemplate.opsForHash().entries(hashKey)
     * 删除哈希字段：redisTemplate.opsForHash().delete(hashKey, field)
     */
    @RequestMapping("hashoperation")
    public void hashoperation() {
        // 获取RedisTemplate实例
        //RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        // 设置RedisTemplate的连接工厂等配置
        // 获取HashOperations实例
        HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
        // 添加哈希字段和值
        hashOps.put("myHash", "field1", "value1");
        hashOps.put("myHash", "field2", "value2");
        hashOps.put("myHash", "field3", "value3");
        // 获取哈希字段对应的值
        String value = hashOps.get("myHash", "field1");
        System.err.println("获取哈希字段 field1 对应的值 :" + value);

        // 获取哈希表所有字段和值
        Map<String, String> entries = hashOps.entries("myHash");
        for (Map.Entry<String, String> entry : entries.entrySet()) {
            String key = entry.getKey();
            String key_value = entry.getValue();
            System.err.println("key: " + key + " 值为：" + key_value);
        }

        // 判断哈希字段是否存在
        boolean hasField = hashOps.hasKey("myHash", "field2");
        System.err.println("判断哈希字段 field2 是否存在 :" + hasField);

        // 删除哈希字段
        hashOps.delete("myHash", "field3");

        entries = hashOps.entries("myHash");
        for (Map.Entry<String, String> entry : entries.entrySet()) {
            String key = entry.getKey();
            String key_value = entry.getValue();
            System.err.println("key: " + key + " 值为：" + key_value);
        }

    }



    /**
     * 列表操作
     * 在列表左侧插入元素：redisTemplate.opsForList().leftPush(key, value)
     * 在列表右侧插入元素：redisTemplate.opsForList().rightPush(key, value)
     * 获取列表指定范围的元素：redisTemplate.opsForList().range(key, start, end)
     * 弹出并获取列表左侧的元素：redisTemplate.opsForList().leftPop(key)
     * 弹出并获取列表右侧的元素：redisTemplate.opsForList().rightPop(key)
     */
    @GetMapping("/listOperation")
    public void listOperation() {
        // 获取RedisTemplate实例
        //RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        // 设置RedisTemplate的连接工厂等配置
        // 获取ListOperations实例
        ListOperations<String, Object> listOps = redisTemplate.opsForList();
        // 在列表左侧插入元素
        listOps.leftPush("myList", "element1");
        listOps.leftPush("myList", "element2");
        listOps.leftPush("myList", "element3");
        // 在列表右侧插入元素
        listOps.rightPush("myList", "element4");
        listOps.rightPush("myList", "element5");
        // 获取列表长度
        Long length = listOps.size("myList");
        // 获取列表指定范围的元素
        List<Object> elements = listOps.range("myList", 0, length - 1);
        for (Object value:elements){
            System.err.println("List<String> elements: "+elements);
        }
        // 弹出并获取列表左侧的元素
        Object leftElement = listOps.leftPop("myList");
        System.err.println("弹出并获取列表左侧的元素1: "+ leftElement);
        System.err.println("弹出并获取列表左侧的元素2: "+ listOps.leftPop("myList"));
        // 弹出并获取列表右侧的元素
        Object rightElement = listOps.rightPop("myList");
        System.err.println("弹出并获取列表右侧的元素1: "+rightElement);
        System.err.println("弹出并获取列表右侧的元素2: "+listOps.rightPop("myList"));
    }


    /**
     * 集合操作：
     * 添加元素到集合：redisTemplate.opsForSet().add(key, values)
     * 获取集合所有元素：redisTemplate.opsForSet().members(key)
     * 判断元素是否在集合中：redisTemplate.opsForSet().isMember(key, value)
     * 从集合中移除元素：redisTemplate.opsForSet().remove(key, values)
     */
    @GetMapping("/setOperation")
    public void setOperation() {
        // 获取RedisTemplate实例
        //RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        // 设置RedisTemplate的连接工厂等配置
        // 获取SetOperations实例
        SetOperations<String, Object> setOps = redisTemplate.opsForSet();
        // 添加元素到集合
        setOps.add("mySet", "element1");
        setOps.add("mySet", "element2");
        setOps.add("mySet", "element3");
        // 获取集合所有元素
        Set<Object> elements = setOps.members("mySet");
        for (Object object:elements){
            System.err.println("Set<Object> elements :"+(String) object);
        }
        // 判断元素是否在集合中
        boolean contains = setOps.isMember("mySet", "element1");
        System.err.println("判断元素是否在集合中 :"+ contains);
        // 从集合中移除元素
        setOps.remove("mySet", "element2");
        elements = setOps.members("mySet");
        for (Object object:elements){
            System.err.println("从集合中移除 element2元素 后 Set<Object> elements :"+(String) object);
        }
    }


    /**
     * 有序集合操作：
     * 添加元素到有序集合：redisTemplate.opsForZSet().add(key, value, score)
     * 获取有序集合指定范围的元素：redisTemplate.opsForZSet().range(key, start, end)
     * 获取有序集合指定分数范围的元素：redisTemplate.opsForZSet().rangeByScore(key, minScore, maxScore)
     * 获取有序集合的元素数量：redisTemplate.opsForZSet().zCard(key)
     *
     * 这些只是RedisTemplate提供的一些常用方法示例，还有其他更多操作和更详细的参数选项可以根据需要进行使用。
     * 你可以参考Spring Data Redis的文档或查看RedisTemplate的源码来获取更多信息。
     */
    @RequestMapping("/orderedSetOperation")
    public void orderedSetOperation() {
        // 获取RedisTemplate实例
        //RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        // 设置RedisTemplate的连接工厂等配置
        // 获取ZSetOperations实例
        ZSetOperations<String, Object> zSetOps = redisTemplate.opsForZSet();
        // 添加元素到有序集合
        zSetOps.add("mySortedSet", "element1", 1.0);
        zSetOps.add("mySortedSet", "element2", 2.0);
        zSetOps.add("mySortedSet", "element3", 3.0);

        // 获取有序集合指定范围的元素
        //ZSetOperations的range方法中，参数start和end表示需要获取的元素的索引范围（包括start和end所指定的元素）。
        // 如果end为-1，表示获取集合中的所有元素，即从第一个元素到最后一个元素的范围。
        //因此，zSetOps.range("mySortedSet", 0, -1)的意思是获取有序集
        Set<Object> elements = zSetOps.range("mySortedSet", 0, -1);
        for (Object object:elements){
            System.err.println("Set<Object> elements :"+(String) object);
        }

        // 获取有序集合指定分数范围的元素
        Set<Object> elementsByScore = zSetOps.rangeByScore("mySortedSet", 2.0, 3.0);
        for (Object object:elementsByScore){
            System.err.println("Set<Object> elements :"+(String) object);
        }

        // 获取有序集合指定元素的排名（从0开始计数）
        Long rank = zSetOps.rank("mySortedSet", "element3");
        System.err.println("获取有序集合指定元素的排名（从0开始计数） :"+ rank);

        // 获取有序集合指定元素的分数
        Double score = zSetOps.score("mySortedSet", "element2");
        System.err.println("获取有序集合指定元素的分数 :"+ score);

        // 从有序集合中移除元素
        zSetOps.remove("mySortedSet", "element1");
        elements = zSetOps.range("mySortedSet", 0, -1);
        for (Object object:elements){
            System.err.println("从有序集合中移除 element1元素 Set<Object> elements :"+(String) object);
        }
    }
}
