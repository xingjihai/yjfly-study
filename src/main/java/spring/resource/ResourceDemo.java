package spring.resource;

import org.springframework.core.io.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.*;


/**
 * 依赖：
 * <dependency>
 <groupId>org.springframework</groupId>
 <artifactId>spring-core</artifactId>
 <version>4.1.3.RELEASE</version>
 </dependency>
 */
public class ResourceDemo {
    public static void main(String[] args) {
        try {

            //WritableResource
            WritableResource writableResource=new PathResource("D:\\develop\\workspace_idea_my\\yjfly-study\\src\\main\\resources\\text.txt");
            System.out.println(  "resource.isWritable():"+  writableResource.isWritable() );

            OutputStream outputStream=writableResource.getOutputStream();
            outputStream.write( "777".getBytes() );
            outputStream.close();


            //相对路径下创建文件
            Resource createResource =writableResource.createRelative("../6666.txt");  //??
            File file=createResource.getFile();
            OutputStream outputStream1=new FileOutputStream(file);
            outputStream1.write( "6666".getBytes() );
            outputStream1.close();

            createResource.getInputStream();

            System.out.println( file.getAbsolutePath() );

//            ClassPathResource resource= new ClassPathResource("text.txt");   //类路径加载
            FileSystemResource resource= new FileSystemResource("D:\\develop\\workspace_idea_my\\yjfly-study\\src\\main\\resources\\text.txt"); //文件的绝对路径加载
            InputStream inputStream=resource.getInputStream();
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            int i;
            while ( (i=inputStream.read())!=-1 ){
                baos.write(i);
            }
            System.out.println( baos.toString() );


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
