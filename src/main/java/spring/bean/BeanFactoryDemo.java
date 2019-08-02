package spring.bean;


import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import spring.bean.config.Bean;

/**
 * 依赖
 * <dependency>
 <groupId>org.springframework</groupId>
 <artifactId>spring-beans</artifactId>
 <version>4.1.3.RELEASE</version>
 </dependency>
 */
public class BeanFactoryDemo {
    public static void main(String[] args) {

        ResourceLoader resourceLoader=new PathMatchingResourcePatternResolver();
        Resource resource=resourceLoader.getResource( "classpath:spring/beans.xml" );
        DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);
        Bean bean =factory.getBean("beanDemo",Bean.class );
        bean.setProperty("111");
        System.out.println( bean.getProperty() );
        System.out.println( "BeanDefinitionCount:"+factory.getBeanDefinitionCount() );
        System.out.println( "SingletonCount:"+factory.getSingletonCount() );

    }
}
