
import com.redis.entity.Case;
import com.redis.entity.User;
import com.redis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
@SuppressWarnings("all")
public class RedisTest {

    @Resource(name="redisTemplate")
    private RedisTemplate redisTemplate;

    @Value("192.168.1.66")
    private String redisHost;

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis(redisHost);
        System.out.println("连接成功");
        //存储数据到列表中
//        jedis.lpush("site-list", "Runoob");
//        jedis.lpush("site-list", "Google");
//        jedis.lpush("site-list", "Taobao");
//        testEntity entity = new testEntity();
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0, 2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("列表项为: " + list.get(i));
        }
    }

    @Test
    public void test1() {
        redisTemplate.delete("myStr");
        redisTemplate.opsForValue().set("myStr", "skyLine");
        System.out.println(redisTemplate.opsForValue().get("myStr"));
        System.out.println("---------------");
    }

    @Test
    public void test2() {
        RedisTemplate redisTemplate=new RedisTemplate();
        redisTemplate.delete("user1");
        User user = new User();
        user.setId("1");
        user.setName("anqi");


//        Case caze=new Case();
//        caze.setCaseCode("(2018)闽0203民初1000号");
//        jedis.lpush("site-list".getBytes(), SerializeUtil.serialize(caze));
//
//
//        Case caze2=new Case();
//        caze2.setCaseCode("(2018)闽0203民初1001号");
//        jedis.lpush("site-list".getBytes(), SerializeUtil.serialize(caze2));


        redisTemplate.opsForValue().set("user1", user);
        User result = (User) redisTemplate.opsForValue().get("user1");
        System.out.println(result);
        System.out.println(result.getId());
        System.out.println(result.getName());
        System.out.println("---------------");
    }

}