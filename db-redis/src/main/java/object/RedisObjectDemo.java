package object;

import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.List;

public class RedisObjectDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Jedis jedis = new Jedis("192.168.1.66");


        Case caze=new Case();
        caze.setCaseCode("(2018)闽0203民初1000号");
        jedis.lpush("site-list".getBytes(), SerializeUtil.serialize(caze));


        Case caze2=new Case();
        caze2.setCaseCode("(2018)闽0203民初1001号");
        jedis.lpush("site-list".getBytes(), SerializeUtil.serialize(caze2));


//        获取存储的数据并输出
        List<byte[]> list = jedis.lrange("site-list".getBytes(), 0, 2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("列表项为: " + ( (Case)SerializeUtil.deserialize(list.get(i))   ).getCaseCode() );
        }
    }
}
