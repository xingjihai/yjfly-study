package spring.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.naming.spi.Resolver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResourceLoaderDemo {



    public static void main(String[] args) {
        try {
            ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
//            Resource resource=resolver.getResource("file:D:\\develop\\workspace_idea_my\\yjfly-study\\src\\main\\resources\\text.txt");
            Resource resource=resolver.getResource("classpath:6666.txt");
            InputStream inputStream=resource.getInputStream();

            ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
            int i;
            while (  (i=inputStream.read())!=-1 ){
                outputStream.write(i);
            }
            System.out.println( outputStream.toString() );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
